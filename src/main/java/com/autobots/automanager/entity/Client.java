package com.autobots.automanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.models.ErrorInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client extends RepresentationModel<Client> implements ErrorInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String socialName;
	@Column
	private Date birthDate;
	@Column
	private Date registrationDate;
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Document> documents = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telephone> telephone = new ArrayList<>();


	public String getObjectName() {
		return getName();
	}
}