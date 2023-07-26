package com.fullstack.processapi.controller;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fullstack.processapi.exception.GlobalExceptionHandler;
import com.fullstack.processapi.model.ProcessData;
import com.fullstack.processapi.repository.ProcessRepository;
import com.fullstack.processapi.service.ProcessService;

@WebMvcTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server 
public class ProcessControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ProcessRepository processRepository;
	
	@InjectMocks
	private ProcessController processController;

	@MockBean
	private ProcessService processService;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(processController).setControllerAdvice(new GlobalExceptionHandler()).build();
	}
	
	@Test
	public void getProcesses() throws Exception {
		List<ProcessData> processDatas = new ArrayList<>();
		Pageable pageable = PageRequest.of(0, 50);
		Mockito.when(processService.getProcessData(null, pageable)).thenReturn(processDatas);
		MockHttpServletResponse response = mockMvc.perform(get("/api/getprocess").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void getProcessesByDomain() throws Exception {
		List<ProcessData> processDatas = new ArrayList<>();
		Pageable pageable = PageRequest.of(0, 50);
		Mockito.when(processService.getProcessData("www.domain1.com", pageable)).thenReturn(processDatas);
		MockHttpServletResponse response = mockMvc.perform(get("/api/getprocess").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void urlNotFound() throws Exception {
		List<ProcessData> processDatas = new ArrayList<>();
		Pageable pageable = PageRequest.of(0, 50);
		Mockito.when(processService.getProcessData(null, pageable)).thenReturn(processDatas);
		MockHttpServletResponse response = mockMvc.perform(get("/api/getproces").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
}