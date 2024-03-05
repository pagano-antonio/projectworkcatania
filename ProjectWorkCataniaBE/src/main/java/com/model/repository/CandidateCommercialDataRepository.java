package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CandidateCommercialData;

@Repository
public interface CandidateCommercialDataRepository extends JpaRepository<CandidateCommercialData, Integer> {

}

