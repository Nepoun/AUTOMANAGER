package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entity.Client;
import com.autobots.automanager.entity.Document;
import com.autobots.automanager.entity.Address;
import com.autobots.automanager.entity.Telephone;
import com.autobots.automanager.repository.ClientRepository;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public ClientRepository repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Calendar calendario = Calendar.getInstance();
			calendario.set(2002, 05, 15);

			Client client = new Client();
			client.setName("Pedro Alcântara de Bragança e Bourbon");
			client.setRegistrationDate(Calendar.getInstance().getTime());
			client.setBirthDate(calendario.getTime());
			client.setSocialName("Dom Pedro");
			
			Telephone telephone = new Telephone();
			telephone.setDdd("21");
			telephone.setNumber("981234576");
			client.getTelephone().add(telephone);
			
			Address address = new Address();
			address.setState("Rio de Janeiro");
			address.setCity("Rio de Janeiro");
			address.setDistrict("Copacabana");
			address.setStreet("Avenida Atlântica");
			address.setNumber("1702");
			address.setZipCode("22021001");
			address.setAdditionalInfo("Hotel Copacabana palace");
			client.setAddress(address);
			
			Document rg = new Document();
			rg.setDocumentType("RG");
			rg.setNumber("1500");
			
			Document cpf = new Document();
			cpf.setDocumentType("RG");
			cpf.setNumber("00000000001");
			
			client.getDocuments().add(rg);
			client.getDocuments().add(cpf);
			
			repositorio.save(client);
		}
	}

}
