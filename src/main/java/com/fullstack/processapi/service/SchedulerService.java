package com.fullstack.processapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fullstack.processapi.model.Database;
import com.fullstack.processapi.model.Databases;
import com.fullstack.processapi.model.TemporaryProcess;

@Component
public class SchedulerService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Databases databases;
	
	@Autowired
	private TemporaryProcess temporaryProcess;
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@Scheduled(fixedRate = 120000)
	public void schedule() {
		logger.info("Get Database scheduler called : " + System.currentTimeMillis());
		List<Database> databases = restTemplateService.getDatabases();
		logger.info(databases.toString());
		this.databases.setDatabase(databases);
	}
	
	@Scheduled(fixedRate = 300000)
	public void removeProcess() {
		logger.info("Temporary process remover scheduler called : " + System.currentTimeMillis());
		temporaryProcess.getProcess().stream().filter(p -> p != null && p.checkExpired()).forEach(p -> {
			logger.info("Temporary Process : " + p);
			temporaryProcess.removeProcess(p);
		});
	}
}