package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.EducationDegreeType;

@Repository
public interface EducationDegreeTypeRepository extends JpaRepository<EducationDegreeType, Integer> {

}
