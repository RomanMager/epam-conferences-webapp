package com.epam.conference.pool;

import lombok.extern.log4j.Log4j2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class ConnectionPool {
    private static final int POOL_SIZE = 10;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static ConnectionPool instance;
    private static ReentrantLock locker = new ReentrantLock();

    // Register DB drivers
    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            log.fatal("Database drivers cannot be loaded." + e);
            throw new RuntimeException(e);
        }
    }

    private BlockingQueue<ProxyConnection> connectionQueue;

    private ConnectionPool() {
        connectionQueue = new LinkedBlockingQueue<>(POOL_SIZE);
        setUpConnection();
    }

    public static ConnectionPool getInstance() {
        if (!instanceCreated.get()) {
            locker.lock();
            try {
                if (!instanceCreated.get()) {
                    instance = new ConnectionPool();
                    instanceCreated.set(true);
                }
            } finally {
                locker.unlock();
            }
        }

        return instance;
    }

    private void setUpConnection() {
        for (int i = 0; i <= POOL_SIZE; i++) {
            try {
                ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(
                        DbProperties.readUrl(),
                        DbProperties.readProperties()
                ));
                connectionQueue.offer(connection);
            } catch (SQLException e) {
                log.error("Unable to initialize Connection Pool.");
                throw new RuntimeException(e);
            }
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            log.error("Cannot retrieve connection.");
        }
        return connection;
    }

    public void releaseConnection(ProxyConnection connection) {
        connectionQueue.offer(connection);
    }

    // deregister drivers
    public void destroy() {
        try {
            for (int i = 0; i < POOL_SIZE; i++) {
                ProxyConnection connection = connectionQueue.take();
                connection.closeConnection();
            }
        } catch (InterruptedException | SQLException e) {
            log.error("Error occurred while closing connections." + e);
        }

        DriverManager.drivers().forEach(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                log.error("Error occurred while deregister drivers." + e);
            }
        });

        log.info("Connections are successfully closed. Drivers have been deregistered.");
    }
}

