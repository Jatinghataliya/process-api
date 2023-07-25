package com.fullstack.processapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.processapi.model.ProcessData;
import com.fullstack.processapi.service.ProcessService;

@RestController
@RequestMapping("/api")
public class ProcessController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProcessService processService;
	
	@GetMapping("/")
	public long getTimeStamp() {
		return System.currentTimeMillis();
	}
	
	@PostMapping("/")
	public void process(@RequestBody List<ProcessData> processes) {
		logger.info("Request Body : " + processes.toString());
		processService.setProcess(processes);
	}
	
}