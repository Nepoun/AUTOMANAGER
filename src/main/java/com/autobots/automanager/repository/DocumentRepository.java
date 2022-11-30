package com.autobots.automanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.entity.Document;;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}