package com.autobots.automanager.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entity.Client;
import com.autobots.automanager.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado", null));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setAddress(obj.getAddress());
		newObj.setBirthDate(obj.getBirthDate());
		newObj.setDocuments(obj.getDocuments());
		newObj.setName(obj.getName());
		newObj.setRegistrationDate(obj.getRegistrationDate());
		newObj.setSocialName(obj.getSocialName());
		newObj.setTelephone(obj.getTelephone());
	}
	
}
