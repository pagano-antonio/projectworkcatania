package com.model.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Candidate;
import com.model.repository.CandidateRepository;

@RestController
@RequestMapping("CandidateRest")
public class CandidateRest {
	
	@Autowired
	CandidateRepository candidateRep;
	
	@GetMapping("/home")
    public String goToHome(Model model) {
        return "home";  
    }
	
	@GetMapping("/preAddCandidate")
    public String insertCandidate(Model model) {
        return "addCandidate";
	} 
	
	@GetMapping("/addCandidate")
    public String addOrUpdateCandidate(Candidate candidate, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		candidateRep.save(candidate);	
        return "addCandidateOk";
    }
	
	@GetMapping("/deleteCandidate")
	public String deleteCandidate(Candidate candidate, Model model) {
		System.out.println("Sto cancellando il candidato!");
		candidateRep.delete(candidate);
		return "deleteCandidateOk";
	}

}
