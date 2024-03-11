package com.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Candidate;
import com.repository.CandidateRepository;

@Controller 
public class CandidateController {   // ricordarsi di fare i nomi e le mappature dei metodi richiamando il termine candidate
	
	@Autowired
	CandidateRepository candidateRep;

	@GetMapping("/home") // PORTA ALLA HOMEPAGE
	public String goToHome() {
		return "homePage";
	}

	@GetMapping("/preAddCandidate") 
	public String insertCandidate() {
		return "addCandidate";
	}

	@PostMapping("/addCandidate") // test okay del metodo!
	public String addOrUpdateCandidate(Candidate candidate, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		candidateRep.save(candidate);
		return "addCandidateOk";
	}

	@PostMapping("/searchById") //da testare!
	public String searchById(Model model, Integer idCandidate) {
		if (candidateRep.findById(idCandidate).isPresent()) {
			Candidate candidate = (Candidate) candidateRep.findById(idCandidate).get();
			model.addAttribute("CandidateFound", candidate);
			return "updateCandidate";
		} else
			return "ErrorPage";
	}
	
	@GetMapping("/preSearchCandidateBySurname") 
	public String preSearchBySurname() {
		return "searchCandidateBySurname";
	}
	
	@PostMapping("/searchCandidateBySurname") //da testare!
	public String searchBySurname(Candidate candidate, Model model, String surname) {
		List<Candidate> candidateList = candidateRep.findBySurname(surname);
		System.out.println("Sto cercando una candidato");
		model.addAttribute("candidateFound", candidateList);
		return "candidateListBySurname";
	}
	
	@PostMapping("/searchCandidateByCity") //da testare!
	public String searchByCity(Candidate candidate, Model model, String city) {
		List<Candidate> candidateList = candidateRep.findByCity(city);
		System.out.println("Sto cercando una candidato");
		model.addAttribute("candidateCityFound", candidateList);
		return "candidateListByCity";
	}
	
	@PostMapping("/searchCandidateByPhone") //da testare!
	public String searchByPhone(Candidate candidate, Model model, BigInteger phone) {
		Candidate candidateFound = (Candidate) candidateRep.findByPhone(phone);
		System.out.println("Sto cercando una candidato");
		model.addAttribute("candidatePhoneFound", candidateFound);
		return "candidateListByPhone";
	}

	
	@PostMapping("/searchCandidateBySkill")//da testare!
	public String searchBySkill(Candidate candidate, Model model, String description) {
		List<Candidate> candidateList = candidateRep.findByCandidateSkills_Skill_description(description);
		System.out.println("Sto cercando un candidato");
		model.addAttribute("candidateSkillFound", candidateList);
		return "candidateListBySkill";
	}
	
	@PostMapping("/searchByEducationDegreeType") //da testare!
	public String searchByEducation(Candidate candidate, Model model, String description) {
		List<Candidate> candidateList = candidateRep.findByEducations_EducationDegreeType_description(description);
		System.out.println("Sto cercando un candidato");
		model.addAttribute("candidateEducationFound", candidateList);
		return "candidateListByEducation";
	}
	
	@PostMapping("/searchByStateJobInterview")
	public String searchByStateJobInterview(Candidate candidate, Model model, String description) {
		List<Candidate> candidateList = candidateRep.findByJobInterviews_stateJobInterview_description(description);
		System.out.println("Sto cercando un candidato");
		model.addAttribute("candidateStateJobFound", candidateList);
		return "candidateListByStateJobInterview";
	}
	
	@GetMapping("/searchByJobInterviewOutcome") //da testare!
	public String searchByJobInterviewOutcome(Candidate candidate, Model model, Integer outcome) {
		List<Candidate> candidateList = candidateRep.findByJobInterviews_outcome(outcome);
		System.out.println("Sto cercando un candidato");
		model.addAttribute("candidateOutcomeJobFound", candidateList);
		return "candidateListByJobInterviewOutcome";
	}
	
	@PostMapping("/searchByWorkExperiencesCompany")// da testare!
	public String searchByCompany(Candidate candidate, Model model, String company) {
		List<Candidate> candidateList = candidateRep.findByWorkExperiences_Company(company);
		System.out.println("Sto cercando un candidato");
		model.addAttribute("candidateCompanyFound", candidateList);
		return "candidateListByWorkExperiencesCompany";
	}
	
	@PostMapping("/deleteCandidate") //da testare!
	public String deleteCandidate(Candidate candidate, Model model) {
		System.out.println("Sto cancellando il candidato!");
		candidateRep.delete(candidate);
		return "deleteCandidateOk";
	}

	
}
