package com.fb.beans;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author : Apoorva Raj
 * @mailto : apoorv.vardhman@gmail.com
 * @LinkedIn : apoorv-vardhman
 **/
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driverClass;
    private String url;
    private String username;
    private String password;

    public ConnectionFactoryBean(String driverClass, String url, String username, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClass);
        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
