package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Integer>  {
		
	List<CandidateSkill> findByCandidate_IdCandidate(Integer idCandidate);
	List<CandidateSkill> findBySkill_IdSkill(Integer idSkill);

	

	
	
}
