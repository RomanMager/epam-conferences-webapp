package com.epam.conference.pool;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ConnectionPoolTest {
    
    // Tests if everything can actually run
    @Test
    public void testRun() {
        ProxyConnection connection = ConnectionPool.getInstance().getConnection();
        ProxyConnection connection1 = ConnectionPool.getInstance().getConnection();
        ProxyConnection connection2 = ConnectionPool.getInstance().getConnection();
        
        log.info(connection);
        log.info(connection1);
        log.info(connection2);
        
        ConnectionPool.getInstance().releaseConnection(connection);
        ConnectionPool.getInstance().releaseConnection(connection1);
        ConnectionPool.getInstance().releaseConnection(connection2);
        
        ConnectionPool.getInstance().destroy();
    }
}
