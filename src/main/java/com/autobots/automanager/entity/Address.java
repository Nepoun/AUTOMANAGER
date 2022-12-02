package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.models.ErrorInfo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends RepresentationModel<Address> implements ErrorInfo{
	@Id
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

	public String getObjectName() {
		return String.format("%s %2d, %3d, %4d, %5d", state, city, district, street, number);
	}
}