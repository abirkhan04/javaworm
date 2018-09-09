package com.javaworm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.javaworm")
@PropertySource("classpath:database.properties")
public class DataConfig {
	
	private final String DRIVER = "hibernate.connection.driver_class";
	private final String URL = "hibernate.connection.url";
	private final String USERNAME = "hibernate.connection.username";
	private final String PASSWORD = "hibernate.connection.password";
	private final String SHOW_SQL = "hibernate.show_sql";
	private final String DIALECT = "hibernate.dialect";
	private final String AUTO = "hibernate.hbm2ddl.auto";
	
	@Autowired
	Environment env;
		
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistence.class);
		lfb.setPackagesToScan("com.javaworm.model");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty(URL));
		ds.setUsername(env.getProperty(USERNAME));
		ds.setPassword(env.getProperty(PASSWORD));
		ds.setDriverClassName(env.getProperty(DRIVER));
		return ds;
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(DIALECT, env.getProperty(DIALECT));
		properties.setProperty(SHOW_SQL, env.getProperty(SHOW_SQL));
		properties.setProperty(AUTO, env.getProperty(AUTO));
		return properties;
	}
	
	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
