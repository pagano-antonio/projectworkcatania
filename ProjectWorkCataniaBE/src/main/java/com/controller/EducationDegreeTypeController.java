package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.EducationDegreeType;
import com.repository.EducationDegreeTypeRepository;

@Controller
@RequestMapping("EducationDegreeTypeController")
public class EducationDegreeTypeController {

	@Autowired
	EducationDegreeTypeRepository educationDegreeTypeRep;
	
	@GetMapping("/preAddEducationDegreeType")
    public String insertEducationDegreeType(Model model) {
        return "addEducationDegreeType";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchById(Model model) {
        return "searchByIdEducationDegreeType";
	} 
	
	
	@PostMapping("/addEducationDegreeType")
    public String addOrEducationDegreeType(EducationDegreeType educationDegreeType, Model model) {
		System.out.println("Sto inserendo/aggiornando un tipo di Diploma/Laurea!");
		educationDegreeTypeRep.save(educationDegreeType);	
        return "addEducationDegreeTypeOk";
    }
	
	@PostMapping("/searchByIdEducationType")
	public String searchByIdEducationType(Model model, Integer idEducationDegreeType) {
		if(educationDegreeTypeRep.findById(idEducationDegreeType).isPresent()) {
		EducationDegreeType educationDegreeType = (EducationDegreeType)educationDegreeTypeRep.findById(idEducationDegreeType).get();
		model.addAttribute("EducationDataFound", educationDegreeType);
		return "updateEducationDegreeType";
		} else 
			return "ErrorPage";
	}	
	
	@PostMapping("/deleteEducationDegreeType")
	public String deleteEducationDegreeType(EducationDegreeType educationDegreeType, Model model) {
		System.out.println("Sto cancellando la laurea/diploma!");
		educationDegreeTypeRep.delete(educationDegreeType);
		return "deleteEducationDegreeTypeOk";
	}

}
