package com.excelr.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {

		// Create a SimpleClientHttpRequestFactory to configure the RestTemplate
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

		// Set Connection timeout (in milliseconds) for HTTP requests
		factory.setConnectTimeout(3000);

		// Set read timeout for HTTP requests
		factory.setReadTimeout(3000);

		//Create and return a RestTemplate using the configured factory
		return new RestTemplate(factory);

	}

}
