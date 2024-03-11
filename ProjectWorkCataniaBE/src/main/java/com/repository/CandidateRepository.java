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
	List<Candidate> findByEducations_EducationDegreeType_description(String description);
	List<Candidate> findByWorkExperiences_Company(String company);
	List<Candidate> findByJobInterviews_stateJobInterview_description(String description);// potrebbe anche essere title?
	List<Candidate> findByJobInterviews_outcome(Integer outcome);

}
