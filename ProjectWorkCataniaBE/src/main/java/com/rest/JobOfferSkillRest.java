package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.JobOfferSkill;
import com.model.Skill;
import com.repository.JobOfferSkillRepository;
import com.repository.SkillRepository;

@RestController
@RequestMapping("JobOfferSkillRest")
public class JobOfferSkillRest {


		
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
		
		@GetMapping("/addJobOfferSkill")
	    public String addOrUpdateJobOfferSkill(JobOfferSkill jobOfferSkill, Model model) {
			System.out.println("Sto inserendo/modificando!");
			jobOfferSkillRep.save(jobOfferSkill);	
	        return "addJobOfferSkillOk";
	    }
			
		@GetMapping("/searchById")
		public String searchById(Model model, Integer idJobOfferSkill) {
			if(jobOfferSkillRep.findById(idJobOfferSkill).isPresent()) {
			JobOfferSkill jobOfferSkill = (JobOfferSkill)jobOfferSkillRep.findById(idJobOfferSkill).get();
			model.addAttribute("JobOfferSkillFound", jobOfferSkill);
			return "updateJobOfferSkill";
			} else 
				return "ErrorPage";
		}
		
		@GetMapping("/deleteJobOfferSkill")
		public String deleteJobOfferSkill(JobOfferSkill jobOfferSkill, Model model) {
			System.out.println("Sto cancellando!");
			jobOfferSkillRep.delete(jobOfferSkill);
			return "deleteJobOfferSkillOk";
		}
}
