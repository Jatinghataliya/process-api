package com.fullstack.processapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fullstack.processapi.model.Database;
import com.fullstack.processapi.model.Domain;
import com.fullstack.processapi.model.ProcessData;

@Service
public class RestTemplateService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${domain.url}")
	private String domainUrl;
	
	@Value("${database.url}")
	private String databaseUrl;
	
	public Domain getDomain(ProcessData processData) {
		ResponseEntity<Domain> responseEntity; 
		try {
			responseEntity = restTemplate.getForEntity(domainUrl + processData.getDomain(), Domain.class);
			Domain domain = responseEntity.getBody();
			return domain;
		} catch (Exception e) {
			return Domain.builder().isDomainNotFound(true).build();
		}
	}
	
	public List<Database> getDatabases(){
		ResponseEntity<List<Database>> responseEntity;
		try {
			responseEntity = restTemplate.exchange(databaseUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Database>>() {});
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
}
