package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.JobInterview;
import com.repository.JobInterviewRepository;

@Controller
@RequestMapping("JobInterviewController")
public class JobInterviewController {


	@Autowired
	JobInterviewRepository jobInterviewRep;
	
	
	@GetMapping("/preAddJobInterview")
    public String insertJobInterview(Model model) {
        return "addJobInterview";
	} 
	
	@GetMapping("/preSearchByIdJobInterview")
    public String preSearchByIdJobInterview(Model model) {
        return "searchByIdJobInterview";
	} 
	
	@GetMapping("/addJobInterview")
    public String addOrUpdateJobInterview(JobInterview jobInterview, Model model) {
		System.out.println("Sto inserendo/modificando!");
		jobInterviewRep.save(jobInterview);	
        return "addJobInterviewOk";
    }
		
	@GetMapping("/searchById")
	public String searchById(Model model, Integer idJobInterview) {
		if(jobInterviewRep.findById(idJobInterview).isPresent()) {
		JobInterview jobInterview = (JobInterview)jobInterviewRep.findById(idJobInterview).get();
		model.addAttribute("JobInterviewFound", jobInterview);
		return "updateJobInterview";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/deleteJobInterview")
	public String deleteJobInterview(JobInterview jobInterview, Model model) {
		System.out.println("Sto cancellando!");
		jobInterviewRep.delete(jobInterview);
		return "deleteJobInterviewOk";
	}

}
