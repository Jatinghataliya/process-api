package com.fullstack.processapi.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ProcessData {
	private String domain;
	private String[] images;
}