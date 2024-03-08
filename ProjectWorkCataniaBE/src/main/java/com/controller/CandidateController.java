package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Candidate;
import com.repository.CandidateRepository;

@Controller 
public class CandidateController {   // ricordarsi di fare i nomi e le mappature dei metodi richiamando il termine candidate
	
	@Autowired
	CandidateRepository candidateRep;
	
	
	@GetMapping("/home")
    public String goToHome() {
        return"homePage";  
    }
	
	@GetMapping("/preAddCandidate")// test okay
    public String insertCandidate() {
        return "addCandidate";
	} 
	
	@GetMapping("/addCandidate")
    public String addOrUpdateCandidate(Candidate candidate, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		candidateRep.save(candidate);	
        return "addCandidateOk";
    }
	
	
@GetMapping("/searchById")
public String searchById(Model model, Integer idCandidate) {
	if(candidateRep.findById(idCandidate).isPresent()) {
	Candidate candidate = (Candidate)candidateRep.findById(idCandidate).get();
	model.addAttribute("CandidateFound", candidate);
	return "updateCandidate";
	} else 
		return "ErrorPage";
}

@GetMapping("/deleteCandidate")
public String deleteCandidate(Candidate candidate, Model model) {
	System.out.println("Sto cancellando il candidato!");
	candidateRep.delete(candidate);
	return "deleteCandidateOk";
}

}
