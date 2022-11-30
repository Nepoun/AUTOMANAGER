package com.autobots.automanager.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.autobots.automanager.entity.Telephone;
import com.autobots.automanager.repository.TelephoneRepository;

@Service
public class TelephoneService {
	@Autowired
	private TelephoneRepository repository;
	
	public List<Telephone> findAll(){
		return repository.findAll();
		
	}
	
	public Telephone findById(Long id) {
		Optional<Telephone> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found", null));
	}
	
	public Telephone insert(Telephone obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Telephone update(Telephone obj) {
		Telephone newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Telephone newObj, Telephone obj) {
		newObj.setDdd(obj.getDdd());
		newObj.setNumber(obj.getNumber());
	}
	
}
