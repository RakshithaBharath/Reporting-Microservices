package com.excelr.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportingMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingMicroservicesApplication.class, args);
		System.out.println("Reporting Microservices");
	}

}
