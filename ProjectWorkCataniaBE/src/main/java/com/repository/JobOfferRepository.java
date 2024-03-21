package com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.JobOffer;

@Repository
public interface JobOfferRepository extends JpaRepository <JobOffer, Integer> {

	
	List<JobOffer> findByTitle (String title);
	List <JobOffer> findByMinRalGreaterThanEqualAndMaxRalLessThanEqual(Integer minRal, Integer maxRal);
	List <JobOffer> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);
}
