package com.rvy.trg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaProductManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProductManagementServiceApplication.class, args);
	}

}
