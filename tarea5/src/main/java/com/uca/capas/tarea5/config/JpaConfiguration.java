package com.uca.capas.tarea5.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("modelo-persistence");
		em.setPackagesToScan("com.uca.capas.tarea5.domain");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		/*
		 * En este caso el servidor postgres se encuentra en la misma maquina (localhost)
		 * Cambiar a la IP correspondiente si en su caso no fuera asi
		 */
		dataSource.setUrl("jdbc:postgresql://localhost:5432/ESTUDIANTE");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		return dataSource;
	}
	Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
		return properties;
	}

}