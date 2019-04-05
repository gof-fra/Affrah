package com.haggar.affrahbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages={"com.haggar.affrahbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	// change the below based on the DBMS we choose
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost/~/affrahDB";
	private final static String DATABASE_DRIVER= "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "haggar";
	private final static String DATABASE_PASSWORD = "haggar";
	
	// dataSource bean w'll be available
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// providing the database connection information
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	// sessionFactory bean w'll be available
	
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.haggar.affrahbackend.dto");
		
		return builder.buildSessionFactory();
	}
	
	// all Hibernate properties w'll be return in this method
	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show.sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	// transactionManager bean
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}

}
