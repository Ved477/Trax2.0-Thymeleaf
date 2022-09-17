package com.spring_restful_service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=40, nullable=false)
	private String name;
	
	@Column(length=120, nullable=false)
	private String email;
	
	@Column(length=10, nullable=false)
	private long mobile;
	
	
}
