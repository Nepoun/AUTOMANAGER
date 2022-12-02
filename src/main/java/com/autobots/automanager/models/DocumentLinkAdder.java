package com.autobots.automanager.models;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.DocumentController;
import com.autobots.automanager.entity.Document;

@Component
public class DocumentLinkAdder implements LinkAdder<Document> {
	
	@Override
	public void addLink(List<Document> documentList) {
		for (Document document : documentList) {
			long id = document.getId();
			Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(DocumentController.class)
							.getDocument(id))
					.withSelfRel();
			document.add(selfLink);
		}
	}
	
	@Override
	public void addLink(Document obj) {
		Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
								.methodOn(DocumentController.class)
								.getAllDocument())
					.withRel("documents");
		obj.add(selfLink);
	}
	
}
