package com.epam.conference.pool;

import java.sql.Connection;

public class ProxyConnection implements Connection, AutoCloseable {
    private Connection connection;
}
