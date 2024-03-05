package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ContractType;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer>{

}
