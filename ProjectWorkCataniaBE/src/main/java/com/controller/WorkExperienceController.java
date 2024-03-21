package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.WorkExperience;
import com.repository.WorkExperienceRepository;

@Controller
@RequestMapping("WorkExperienceController")
public class WorkExperienceController {
	
	@Autowired
	WorkExperienceRepository workExperienceRep;

	
	@GetMapping("/preAddWorkExperience")
	public String insertWorkExperience(Model model) {
		return "addWorkExperience";
	}
	
	@PostMapping("addWorkExperience")
	public String addOrUpdateWorkExperience(WorkExperience workExperience, Model model) {
		System.out.println("Sto inserendo/modificando un'esperienza lavorativa!");
		workExperienceRep.save(workExperience);
		return "addWorkExperiemceOk";	
	}
	
	@PostMapping("/deleteWorkExperience")
	public String deleteWorkExperience(WorkExperience workExperience, Model model) {
		System.out.println("Sto cancellando l'esperienza lavorativa");
		workExperienceRep.delete(workExperience);
		return "deleteWorkExperienceOk";		
	}
	
	@PostMapping("/searchByWorkExperienceId")
	public String searchByWorkExperienceId(Model model, Integer id) {
		if(workExperienceRep.findById(id).isPresent()) {
		WorkExperience workExperience = (WorkExperience)workExperienceRep.findById(id).get();
		model.addAttribute("WorkExperienceFound", workExperience);
		return "updateWorkExperienceId";
		} else 
			return "errorPage";
	}
	
	@PostMapping("/searchByIdCandidate")
	public String searchByIdCandidate(Model model, Integer idCandidate) {
		List<WorkExperience> workExperience = workExperienceRep.findByCandidate_idCandidate(idCandidate);
		model.addAttribute("WorkExperienceFound", workExperience);
		return "candidateListByCity";
	}
	

}
