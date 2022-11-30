package com.autobots.automanager.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entity.Document;
import com.autobots.automanager.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository repository;
	
	public List<Document> findAll(){
		return repository.findAll();
	}
	
	public Document findById(Long id) {
		Optional<Document> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found", null));
	}
	
	public Document insert(Document obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Document update(Document obj) {
		Document newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Document newObj, Document obj) {
		newObj.setDocumentType(obj.getDocumentType());
		newObj.setNumber(obj.getNumber());
	}
	
}
