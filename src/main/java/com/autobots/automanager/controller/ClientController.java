package com.autobots.automanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Client;
import com.autobots.automanager.services.ClientService;



@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> allClients = service.findAll();
		return new ResponseEntity<>(allClients, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id){
		Client client = service.findById(id);
		return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> insertNewClient(@RequestBody Client obj){

		service.insert(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateClient(@RequestBody Client obj){
		service.update(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
}
