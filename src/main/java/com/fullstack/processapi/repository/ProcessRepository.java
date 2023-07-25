package com.fullstack.processapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<com.fullstack.processapi.entity.Process, Integer> {

}