package com.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CandidateCommercialData;

@Repository
public interface CandidateCommercialDataRepository extends JpaRepository<CandidateCommercialData, Integer> {

	List<CandidateCommercialData> findByCandidate_id (Integer id);
}

