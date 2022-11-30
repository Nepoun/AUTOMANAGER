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

import com.autobots.automanager.entity.Telephone;
import com.autobots.automanager.services.TelephoneService;





@RestController
@RequestMapping("/telephone")
public class TelephoneController {
	
	@Autowired
	private TelephoneService service;
	
	@GetMapping("/telephones")
	public ResponseEntity<List<Telephone>> getAllTelephones(){
		List<Telephone> allTelephones = service.findAll();
		return new ResponseEntity<>(allTelephones, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/telephone/{id}")
	public ResponseEntity<Telephone> getTelephone(@PathVariable Long id){
		Telephone telephone = service.findById(id);
		return new ResponseEntity<>(telephone, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> insertNewTelephone(@RequestBody Telephone obj){
		service.insert(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTelephone(@RequestBody Telephone obj){
		service.update(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTelephone(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
}
