package com.fullstack.processapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends PagingAndSortingRepository<com.fullstack.processapi.entity.Process, Integer> {
	List<com.fullstack.processapi.entity.Process> findByDomain(String domain, Pageable pageable);
}