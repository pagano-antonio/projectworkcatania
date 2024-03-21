package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

	List<Education> findByCandidate_idCandidate(Integer idCandidate);
}
