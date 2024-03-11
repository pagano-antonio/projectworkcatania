package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.CandidateSkill;
import com.repository.CandidateSkillRepository;

@Controller
@RequestMapping("CandidateSkillController")
public class CandidateSkillController {

	@Autowired
	CandidateSkillRepository candidateSkillRep;
	
	@GetMapping("/preAddCandidateSkill")
    public String insertCandidateSkill(Model model) {
        return "addCandidateSkill";
	} 
	
	@PostMapping("/addCandidateSkill") // test okay!
    public String addOrUpdateCandidateSkill(CandidateSkill candidateSkill, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		System.out.println(candidateSkill);
		candidateSkillRep.save(candidateSkill);	
        return "addCandidateSkillOk";
    }

	@PostMapping("/deleteCandidateSkill")
	public String deleteCandidateSkill(CandidateSkill candidateSkill, Model model) {
		System.out.println("Sto cancellando il candidato!");
		candidateSkillRep.delete(candidateSkill);
		return "deleteCandidateSkillOk";
	}

	@PostMapping("/searchById")
	public String searchById(Model model, Integer idCandidateSkill) {
		if(candidateSkillRep.findById(idCandidateSkill).isPresent()) {
		CandidateSkill candidate = (CandidateSkill)candidateSkillRep.findById(idCandidateSkill).get();
		model.addAttribute("CandidateFound", candidate);
		return "updateCandidate";
		} else 
			return "ErrorPage";
	}
	@PostMapping("/searchByIdCandidate")
	public String searchByIdCandidate(Model model, Integer idCandidate) {
		List<CandidateSkill> candidateList = candidateSkillRep.findByCandidate_IdCandidate(idCandidate);
		model.addAttribute("CandidateListFound", candidateList);
		return "updateCandidate";
		}
	@PostMapping("/searchByIdSkill")
	public String searchByIdSkill(Model model, Integer idSkill) {
		List<CandidateSkill> candidateSkillList = candidateSkillRep.findBySkill_IdSkill(idSkill);
		model.addAttribute("CandidateSkillListFound", candidateSkillList);
		return "updateCandidate";
		}
}
