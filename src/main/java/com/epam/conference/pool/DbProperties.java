package com.epam.conference.pool;

import java.util.Properties;
import java.util.ResourceBundle;

public class DbProperties {
    private static ResourceBundle bundle;
    
    static {
        bundle = ResourceBundle.getBundle("database");
    }
    
    private DbProperties() {
    }
    
    // TODO: rename?
    public static Properties readProperties() {
        Properties properties = new Properties();
        
        properties.setProperty("user", bundle.getString("db.user"));
        properties.setProperty("password", bundle.getString("db.password"));
        properties.setProperty("useSSL", bundle.getString("db.useSSL"));
        properties.setProperty("autoReconnect", bundle.getString("db.autoReconnect"));
        properties.setProperty("useUnicode", bundle.getString("db.useUnicode"));
        properties.setProperty("characterEncoding", bundle.getString("db.characterEncoding"));
        
        return properties;
    }
    
    // TODO: rename?
    public static String readUrl() {
        return bundle.getString("db.url");
    }
}
