package com.fullstack.processapi.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fullstack.processapi.entity.Process;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@Service
public class TemporaryProcess {

	private List<com.fullstack.processapi.entity.Process> process;
	
	public void addProcess(com.fullstack.processapi.entity.Process domain) {
		process.add(domain);
	}
	
	public void removeProcess(Process process) {
		this.process.remove(process);
	}
	
	public void setProcess(List<com.fullstack.processapi.entity.Process> process) {
		this.process = process;
	}
	
	public List<Process> getProcess(){
		return this.process;
	}
}
