package com.excelr.microservices.services;

import java.net.URISyntaxException;
import java.util.List;

import com.excelr.microservices.dto.ApplicationDTO;

public interface IRestClient {
	
	public List<ApplicationDTO> findaAll() throws URISyntaxException;

}
