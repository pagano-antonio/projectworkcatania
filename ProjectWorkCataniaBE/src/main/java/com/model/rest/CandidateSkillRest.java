package com.model.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CandidateSkill;
import com.model.repository.CandidateSkillRepository;

@RestController
@RequestMapping("CandidateSkillRest")
public class CandidateSkillRest {

	@Autowired
	CandidateSkillRepository candidateSkillRep;
	
	@GetMapping("/preAddCandidateSkill")
    public String insertCandidateSkill(Model model) {
        return "addCandidateSkill";
	} 
	
	@GetMapping("/addCandidateSkill")
    public String addOrUpdateCandidateSkill(CandidateSkill candidateSkill, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		candidateSkillRep.save(candidateSkill);	
        return "addCandidateSkillOk";
    }
	

	@GetMapping("/deleteCandidateSkill")
	public String deleteCandidateSkill(CandidateSkill candidateSkill, Model model) {
		System.out.println("Sto cancellando il candidato!");
		candidateSkillRep.delete(candidateSkill);
		return "deleteCandidateSkillOk";
	}

	@PostMapping("/searchById")
	public String searchById(Model model, Integer id) {
		if(candidateSkillRep.findById(id).isPresent()) {
		CandidateSkill candidate = (CandidateSkill)candidateSkillRep.findById(id).get();
		model.addAttribute("CandidateFound", candidate);
		return "updateCandidate";
		} else 
			return "ErrorPage";
	}
	@PostMapping("/searchByIdCandidate")
	public String searchByIdCandidate(Model model, Integer idCandidate) {
		List<CandidateSkill> candidateList = candidateSkillRep.findByIdCandidate(idCandidate);
		model.addAttribute("CandidateListFound", candidateList);
		return "updateCandidate";
		}
	@PostMapping("/searchByIdSkill")
	public String searchByIdSkill(Model model, Integer idSkill) {
		List<CandidateSkill> candidateSkillList = candidateSkillRep.findByIdSkill(idSkill);
		model.addAttribute("CandidateSkillListFound", candidateSkillList);
		return "updateCandidate";
		}
  }	

