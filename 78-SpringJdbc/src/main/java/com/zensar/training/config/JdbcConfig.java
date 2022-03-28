package com.zensar.training.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.zensar.training")
public class JdbcConfig {

	 @Bean
     public DataSource dataSource() {
         DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/TrainingDB");
         dataSource.setUsername("root");
         dataSource.setPassword("root");
         return dataSource;
     }
}
