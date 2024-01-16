package com.waterquality.waterqualitymanagementrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class WaterQualityManagementRestApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(WaterQualityManagementRestApplication.class, args);
	}
}
//		DataSource datasource = context.getBean(DataSource.class);
//
//		Environment environment environment = context.getBean(Environment.class);
//
//		System.out.println("Connected Database : "+ dataSource.getConnection().getMetaData().getURL());
//
//		System.out.println("Active Profile : "+ Arrays.stream(environment.getActiveProfiles()).toList());