package com.autobots.automanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}