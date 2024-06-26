package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CompanyClient;

@Repository
public interface CompanyClientRepository extends JpaRepository<CompanyClient, Integer> {

	List<CompanyClient> findByName(String name);
	List<CompanyClient> findByCity(String name);

}
