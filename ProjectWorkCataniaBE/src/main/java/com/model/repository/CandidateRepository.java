package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
