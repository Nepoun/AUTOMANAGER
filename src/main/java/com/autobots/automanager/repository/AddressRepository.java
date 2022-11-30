package com.autobots.automanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}