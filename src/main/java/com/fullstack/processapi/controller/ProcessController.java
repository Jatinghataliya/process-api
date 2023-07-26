package com.fullstack.processapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.processapi.model.ProcessData;
import com.fullstack.processapi.service.ProcessService;

@RestController
@RequestMapping("/api")
public class ProcessController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProcessService processService;
	
	@GetMapping("/getprocess")
	public List<ProcessData> getTimeStamp(@RequestParam(value = "domain", required = false) String domain,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "50") int size) {
		return processService.getProcessData(domain, PageRequest.of(page, size));
	}
	
	@PostMapping("/setprocess")
	public void process(@RequestBody List<ProcessData> processes) {
		logger.info("Request Body : " + processes.toString());
		processService.setProcess(processes);
	}
	
}