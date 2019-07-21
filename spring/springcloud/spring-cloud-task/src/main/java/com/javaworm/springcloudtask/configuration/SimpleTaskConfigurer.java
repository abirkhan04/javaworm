package com.javaworm.springcloudtask.configuration;

import javax.sql.DataSource;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

public class SimpleTaskConfigurer extends DefaultTaskConfigurer{
    public SimpleTaskConfigurer(DataSource dataSource){
        super(dataSource);
    }
}

