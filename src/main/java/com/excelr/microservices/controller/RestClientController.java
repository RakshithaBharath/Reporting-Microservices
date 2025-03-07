package com.excelr.microservices.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.microservices.dto.ApplicationDTO;
import com.excelr.microservices.services.IRestClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/requests")
public class RestClientController {
	
	@Autowired
	IRestClient restClient;
	
	@GetMapping()
	public ResponseEntity<List<ApplicationDTO>> getApplications() throws URISyntaxException {
		log.info("Inside application controller and calling get application method ");

		List<ApplicationDTO> applicationDTOs = null;
		applicationDTOs = restClient.findaAll();
		log.info("Fetching Data from service layer: {}", applicationDTOs);

		if (CollectionUtils.isEmpty(applicationDTOs)) {
			log.info("Fetched 0 records from Database");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ApplicationDTO>>(applicationDTOs, HttpStatus.OK);
	}


}
