package com.endava.springhibernate.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;


@Configuration
@PropertySource("application.properties")
public class DataConfig {

    @Autowired
    Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Resource config= (Resource) new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(env.getProperty("models.entity.package"));
        sessionFactory.setDataSource(dataSource());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource ds=new BasicDataSource();

        //Driver class name
        ds.setDriverClassName("org.h2.Driver"); //tuka konfiguracija za jdbc

        //set URL
        ds.setUrl("jdbc:h2:file:~/hibernate"); //za url localhost

        //Set username & password
        ds.setUsername("sa");

        ds.setPassword("");


        return ds;

    }


}
