package com.autobots.automanager.models;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.ClientController;
import com.autobots.automanager.entity.Client;

@Component
public class ClientLinkAdder implements LinkAdder<Client> {
	
	@Override
	public void addLink(List<Client> clientList) {
		for (Client client : clientList) {
			long id = client.getId();
			Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ClientController.class)
							.getClient(id))
					.withSelfRel();
			client.add(selfLink);
		}
	}
	
	@Override
	public void addLink(Client obj) {
		Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
								.methodOn(ClientController.class)
								.getAllClients())
					.withRel("clients");
		obj.add(selfLink);
	}
	
}
