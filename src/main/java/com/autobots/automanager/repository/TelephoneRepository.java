package com.autobots.automanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.entity.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}