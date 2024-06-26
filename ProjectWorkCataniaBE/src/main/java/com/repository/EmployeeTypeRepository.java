package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.EmployeeType;


@Repository
public interface EmployeeTypeRepository extends JpaRepository <EmployeeType, Integer>{

}
