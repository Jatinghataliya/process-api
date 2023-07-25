package com.fullstack.processapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "process")
public class Process {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String domain;
	private String[] images;
	@Transient
	private long timeStamp;
	
	public boolean checkExpired() {
		return System.currentTimeMillis() - this.timeStamp >= 300000; 
	}
}