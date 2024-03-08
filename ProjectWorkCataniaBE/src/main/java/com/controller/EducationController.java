package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Education;
import com.repository.EducationRepository;

@Controller
@RequestMapping("EducationController")
public class EducationController {


	@Autowired
	EducationRepository educationRep;
	
	@GetMapping("/preAddEducation")
    public String insertEducation(Model model) {
        return "addEducation";
	} 
	
	@GetMapping("/preSearchByIdEducation")
    public String preSearchByIdEducation(Model model) {
        return "searchByIdEducation";
	} 
	
	@GetMapping("/addEducation")
    public String addOrUpdateEducation(Education education, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		educationRep.save(education);	
        return "addEducationOk";
    }
		
	@GetMapping("/searchById")
	public String searchById(Model model, Integer idEducation) {
		if(educationRep.findById(idEducation).isPresent()) {
		Education education = (Education)educationRep.findById(idEducation).get();
		model.addAttribute("EducationFound", education);
		return "updateEducation";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/deleteCandidate")
	public String deleteCandidate(Education education, Model model) {
		System.out.println("Sto cancellando il candidato!");
		educationRep.delete(education);
		return "deleteEducationOk";
	}
}
