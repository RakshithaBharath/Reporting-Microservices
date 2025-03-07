package com.excelr.microservices.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.excelr.microservices.dto.ApplicationDTO;

@Service
public class RestClientImpl implements IRestClient {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${application.url}")
	private String applicationUrl;

	private static Logger LOGGER = LoggerFactory.getLogger(RestClientImpl.class);

	@Override
	public List<ApplicationDTO> findaAll() throws URISyntaxException {
		// TODO Auto-generated method stub\
		LOGGER.info("Inside Reporting RestClientImpl: findAll and applicationGetAllUrl: {}", applicationUrl);

		URI uri = new URI(applicationUrl);

		ResponseEntity<ApplicationDTO[]> response = restTemplate.getForEntity(uri, ApplicationDTO[].class);

		ApplicationDTO[] applicationArray = response.getBody();

		return Arrays.asList(applicationArray);
	}

}
