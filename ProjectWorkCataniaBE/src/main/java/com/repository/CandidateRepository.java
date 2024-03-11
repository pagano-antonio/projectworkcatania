package com.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	
	List<Candidate> findBySurname(String surname);
	List<Candidate> findByCity(String city);
	List<Candidate> findByPhone(BigInteger phone);
	List<Candidate> findByCandidateSkills_Skill_description(String description); 

}
