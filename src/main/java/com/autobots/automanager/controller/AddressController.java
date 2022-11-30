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

import com.autobots.automanager.entity.Address;
import com.autobots.automanager.entity.Client;
import com.autobots.automanager.services.AddressService;
import com.autobots.automanager.services.ClientService;



@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAllClients(){
		List<Address> allAddress = service.findAll();
		return new ResponseEntity<>(allAddress, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getClient(@PathVariable Long id){
		Address address = service.findById(id);
		return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> insertNewAddress(@RequestBody Address obj){
		service.insert(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAddress(@RequestBody Address obj){
		service.update(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
}
