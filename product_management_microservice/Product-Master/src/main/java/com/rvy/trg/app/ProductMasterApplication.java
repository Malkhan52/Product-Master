package com.rvy.trg.app;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.sapient")

@EnableOpenApi
@EnableDiscoveryClient
public class ProductMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMasterApplication.class, args);
	}
	
	@Bean
	public Docket openApiPetStore() {
		return new Docket(DocumentationType.OAS_30)
				.groupName("open-api-product-management-service")
				.select()
				.paths(cmsPaths())
				.build();
	}

	private Predicate<String> cmsPaths() {
		return regex(".*/pms/v1/.*");
	}

}
