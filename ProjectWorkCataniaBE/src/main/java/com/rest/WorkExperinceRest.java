package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.WorkExperience;
import com.repository.WorkExperienceRepository;

@RestController
@RequestMapping("WorkExperienceRest") // tutto da testare
public class WorkExperinceRest {
	
	@Autowired
	WorkExperienceRepository workExperienceRep;
	
	@GetMapping("/home")
	public String goToHome(Model model) {
		return "home";
	}
	
	@GetMapping("/preAddWorkExperience")
	public String insertWorkExperience(Model model) {
		return "addWorkExperience";
	}
	
	@GetMapping("addWorkExperience")
	public String addOrUpdateWorkExperience(WorkExperience workExperience, Model model) {
		System.out.println("Sto inserendo/modificando un'esperienza lavorativa!");
		workExperienceRep.save(workExperience);
		return "addWorkExperiemceOk";	
	}
	
	@GetMapping("/deleteWorkExperience")
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
		return "updateW";
		} else 
			return "ErrorPage";
	}
	
}
