package com.fullstack.processapi.adaptor;

import com.fullstack.processapi.entity.Process;
import com.fullstack.processapi.model.ProcessData;

public class ProcessAdaptor {

	public static Process getProces(ProcessData processData) {
		return Process.builder().domain(processData.getDomain()).images(processData.getImages()).build();
	}
	
}