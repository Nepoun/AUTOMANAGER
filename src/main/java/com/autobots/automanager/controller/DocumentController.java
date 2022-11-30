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

import com.autobots.automanager.entity.Document;
import com.autobots.automanager.services.DocumentService;





@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private DocumentService service;
	
	@GetMapping("/documents")
	public ResponseEntity<List<Document>> getAllDocument(){
		List<Document> allDocuments = service.findAll();
		return new ResponseEntity<>(allDocuments, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/document/{id}")
	public ResponseEntity<Document> getDocument(@PathVariable Long id){
		Document document = service.findById(id);
		return new ResponseEntity<>(document, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> insertNewDocument(@RequestBody Document obj){
		service.insert(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateDocument(@RequestBody Document obj){
		service.update(obj);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDocument(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>("successful request", HttpStatus.ACCEPTED);	
	}
}
