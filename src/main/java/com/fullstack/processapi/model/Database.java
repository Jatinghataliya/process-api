package com.fullstack.processapi.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Database {
	private int id;
	private String host;
	private String schema;
	private String user;
	private String password;
}