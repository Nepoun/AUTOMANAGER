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
import com.autobots.automanager.models.AddressLinkAdder;
import com.autobots.automanager.models.ErrorTreatment;
import com.autobots.automanager.services.AddressService;



@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@Autowired
	private AddressLinkAdder linkAdder;
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAllAddresses(){
		List<Address> allAddresses = service.findAll();
		if(allAddresses.isEmpty()) {
			ResponseEntity<List<Address>> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return response;
		}else {
			linkAdder.addLink(allAddresses);
			ResponseEntity<List<Address>> response = new ResponseEntity<>(allAddresses, HttpStatus.ACCEPTED);
			return response;
		}
	}
	
	@GetMapping("/document/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable Long id){
		Address address = service.findById(id);
		
		if(address == null) {
			ResponseEntity<Address> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			linkAdder.addLink(address);
			ResponseEntity<Address> response = new ResponseEntity<>(address, HttpStatus.FOUND);
			return response;
		}
	}
	@PostMapping("/register")
	public ResponseEntity<?> insertNewAddress(@RequestBody Address obj){
        ErrorTreatment<Address> errorTreatment = new ErrorTreatment<>();
		HttpStatus status;
		String responseString;
		
        errorTreatment.checkCopyItemToList(service.findAll(), obj);
        

        if(errorTreatment.getHasCopyError()) {
        	
        	responseString = "Object has a copy. Object:" + errorTreatment.getHasCopyError();
            status = HttpStatus.CONFLICT;
            
        }else if(errorTreatment.getIsNullError()){
        	
            status = HttpStatus.NOT_FOUND;
            responseString = "Body cannot be null";    
            
        }else {
        	
            status = HttpStatus.ACCEPTED;
            responseString = "Successful request";
            
        	service.insert(obj);
        }
        return new ResponseEntity<>(responseString, status);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAddress(@RequestBody Address obj){
		HttpStatus status;
		String responseString;
		
		ErrorTreatment<Address> errorTreatment = new ErrorTreatment<>();
		errorTreatment.isObjectNull(obj);
		
		if(errorTreatment.getIsNullError()) {
			
			responseString = errorTreatment.getErrorLog();
			status = HttpStatus.NOT_FOUND;
			
		}else {
			
			responseString = "Successful request";
			status = HttpStatus.ACCEPTED;
			
			service.update(obj);
		}
		
		return new ResponseEntity<>(responseString, status);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long id){
		HttpStatus status;
		String responseString;
		
		ErrorTreatment<Address> errorTreatment = new ErrorTreatment<>();
		
		Address address = service.findById(id);
		
		if(errorTreatment.isObjectNull(address)) {
			status = HttpStatus.NOT_FOUND;
			responseString = "Object not found";
		}else {
			status = HttpStatus.ACCEPTED;
			responseString = "Successful request";
			service.delete(id);
			
		}
		
		return new ResponseEntity<>(responseString, status);	
	}
}
