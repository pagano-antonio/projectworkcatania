package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CompanyClient;

@Repository
public interface CompanyClientRepository extends JpaRepository<CompanyClient, Integer> {

}
