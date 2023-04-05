package com.fb.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : Apoorva Raj
 * @mailto : apoorv.vardhman@gmail.com
 * @LinkedIn : apoorv-vardhman
 **/
public class UserAccessor implements BeanFactoryAware {
    private BeanFactory beanFactory;
    public void showUsers() throws SQLException {
        Connection connection=null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = beanFactory.getBean("connection", Connection.class);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from customers");
            while (resultSet.next()){
                System.out.println("user id "+resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
