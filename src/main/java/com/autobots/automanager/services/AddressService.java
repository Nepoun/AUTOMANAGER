package com.autobots.automanager.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entity.Address;
import com.autobots.automanager.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found", null));
	}
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Address update(Address obj) {
		Address newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Address newObj, Address obj) {
		newObj.setState(obj.getState());
		newObj.setAdditionalInfo(obj.getAdditionalInfo());
		newObj.setCity(obj.getCity());
		newObj.setDistrict(obj.getDistrict());
		newObj.setNumber(obj.getNumber());
		newObj.setState(obj.getState());
		newObj.setStreet(obj.getStreet());
		newObj.setZipCode(obj.getZipCode());
	}
	
}
