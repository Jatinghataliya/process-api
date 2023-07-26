package com.fullstack.processapi.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fullstack.processapi.model.ProcessData;

@WebMvcTest
public class ProcessServiceTest {

	@MockBean
	private ProcessService processService;
	
	@Test
	void process() throws Exception{
		List<ProcessData> processDatas = new ArrayList<>();
		String[] str = {"image1.jpg","somepath/anotherpath/image2.gif"};
		String[] str2 = {"image3.jpg","somepath/anotherpath/image4.gif"};
		processDatas.add(ProcessData.builder().domain("www.domain1.com").images(str).build());
		processDatas.add(ProcessData.builder().domain("www.domain2.com").images(str2).build());
        Mockito.doThrow(new Exception()).doNothing().when(processService).setProcess(processDatas);
	}
}