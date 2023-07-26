package com.fullstack.processapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fullstack.processapi.adaptor.ProcessAdaptor;
import com.fullstack.processapi.entity.Process;
import com.fullstack.processapi.model.*;
import com.fullstack.processapi.repository.ProcessRepository;
@Service
public class ProcessService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProcessRepository processRepository;
	
	@Autowired
	private TemporaryProcess temporaryProcess;
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@Autowired
	private Databases databases;
	
	public void setProcess(List<ProcessData> processes) {
		processes.forEach(p -> {
			Process process = ProcessAdaptor.getProces(p);
			logger.info("Process : " + process);
			Domain domain = restTemplateService.getDomain(p);
			logger.info("Domain : " + domain);
			if (domain.isDomainNotFound()) {
				Database database = databases.getDatabase(process.getId());
				process.setTimeStamp(System.currentTimeMillis());
				temporaryProcess.addProcess(process);
			} else {
				processRepository.save(process);
			}
		});
	}
	
	public List<ProcessData> getProcessData(String domain, Pageable pageable){
		if (domain == null || domain.isEmpty()) {
			return processRepository.findAll(pageable).getContent().stream().map(p -> ProcessAdaptor.getProcessData(p)).collect(Collectors.toList());
		}
		return processRepository.findByDomain(domain, pageable).stream().map(p -> ProcessAdaptor.getProcessData(p)).collect(Collectors.toList());
	}
}