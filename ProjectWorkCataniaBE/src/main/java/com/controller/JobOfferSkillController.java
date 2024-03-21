package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.JobOfferSkill;
import com.repository.JobOfferSkillRepository;

@Controller
@RequestMapping("JobOfferSkillController")
public class JobOfferSkillController {


	
	@Autowired
	JobOfferSkillRepository jobOfferSkillRep;
	
	
	@GetMapping("/preAddJobOfferSkill")
    public String insertJobOfferSkill(Model model) {
        return "addJobOfferSkill";
	} 
	
	@GetMapping("/preSearchByIdJobOfferSkill")
    public String preSearchByIdJobOfferSkill(Model model) {
        return "searchByIdJobOfferSkill";
	} 
	
	@PostMapping("/addJobOfferSkill")
    public String addOrUpdateJobOfferSkill(JobOfferSkill jobOfferSkill, Model model) {
		System.out.println("Sto inserendo/modificando!");
		jobOfferSkillRep.save(jobOfferSkill);	
        return "addJobOfferSkillOk";
    }
		
	@PostMapping("/searchById")
	public String searchById(Model model, Integer idJobOfferSkill) {
		if(jobOfferSkillRep.findById(idJobOfferSkill).isPresent()) {
		JobOfferSkill jobOfferSkill = (JobOfferSkill)jobOfferSkillRep.findById(idJobOfferSkill).get();
		model.addAttribute("JobOfferSkillFound", jobOfferSkill);
		return "updateJobOfferSkill";
		} else 
			return "ErrorPage";
	}
	
	@PostMapping("/deleteJobOfferSkill")
	public String deleteJobOfferSkill(JobOfferSkill jobOfferSkill, Model model) {
		System.out.println("Sto cancellando!");
		jobOfferSkillRep.delete(jobOfferSkill);
		return "deleteJobOfferSkillOk";
	}
}
