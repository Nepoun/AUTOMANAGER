package com.autobots.automanager.models;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.AddressController;
import com.autobots.automanager.entity.Address;

@Component
public class AddressLinkAdder implements LinkAdder<Address> {
	
	@Override
	public void addLink(List<Address> addressList) {
		for (Address address : addressList) {
			long id = address.getId();
			Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(AddressController.class)
							.getAddress(id))
					.withSelfRel();
			address.add(selfLink);
		}
	}
	
	@Override
	public void addLink(Address obj) {
		Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
								.methodOn(AddressController.class)
								.getAllAddresses())
					.withRel("addresses");
		obj.add(selfLink);
	}
	
}
