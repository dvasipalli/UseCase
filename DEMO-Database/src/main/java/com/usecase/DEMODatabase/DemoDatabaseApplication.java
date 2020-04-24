package com.usecase.DEMODatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDatabaseApplication.class, args);
	}

}
