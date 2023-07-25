package com.fullstack.processapi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Component
public class Databases {
	
	private List<Database> databases;
	
	public Database getDatabase(int dbId) {
		return databases.stream().filter(d -> d.getId() == dbId).findAny().orElse(null);
	}
	
	public void setDatabase(List<Database> databases) {
		this.databases = databases;
	}
}
