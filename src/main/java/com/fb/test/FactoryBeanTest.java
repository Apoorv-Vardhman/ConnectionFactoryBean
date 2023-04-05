package com.fb.test;

import com.fb.beans.UserAccessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.sql.SQLException;

/**
 * @author : Apoorva Raj
 * @mailto : apoorv.vardhman@gmail.com
 * @LinkedIn : apoorv-vardhman
 **/
public class FactoryBeanTest {
    public static void main(String[] args) {
        // TODO XmlBeanFactory is an implementation of BeanFactory that is deprecated in spring 5 and completely removed from spring 6 onward
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        // load objects to the IOC container
        reader.loadBeanDefinitions(new ClassPathResource("common/application-context.xml"));
        UserAccessor userAccessor = beanFactory.getBean("userAccessor", UserAccessor.class);
        try {
            userAccessor.showUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
