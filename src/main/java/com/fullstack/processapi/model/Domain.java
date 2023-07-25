package com.fullstack.processapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Domain {
	private String domain;
	private int dbId;	
	private boolean isDomainNotFound;
}
