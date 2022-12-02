package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.models.ErrorInfo;

import lombok.Data;

@Data
@Entity
public class Telephone extends RepresentationModel<Telephone> implements ErrorInfo{
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String ddd;
	@Column
	private String number;

	public String getObjectName() {
		return String.format("(%s) %2d", ddd, number);
	}
	
}