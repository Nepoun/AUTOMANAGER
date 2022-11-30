package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Address {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	private String state;
	@Column(nullable = false)
	private String city;
	@Column(nullable = true)
	private String district;
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String number;
	@Column(nullable = true)
	private String zipCode;
	@Column(unique = false, nullable = true)
	private String additionalInfo;


}