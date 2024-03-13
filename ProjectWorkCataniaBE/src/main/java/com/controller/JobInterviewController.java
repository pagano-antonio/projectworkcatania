package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Candidate;
import com.model.Employee;
import com.model.JobInterview;
import com.model.StateJobInterview;
import com.repository.CandidateRepository;
import com.repository.EmployeeRepository;
import com.repository.JobInterviewRepository;
import com.repository.StateJobInterviewRepository;

@Controller
@RequestMapping("JobInterviewController")
public class JobInterviewController {


	@Autowired
	JobInterviewRepository jobInterviewRep;
	
	@Autowired
	EmployeeRepository employeeRep;
	
	@Autowired
	CandidateRepository candidateRep;
	
	@Autowired
	StateJobInterviewRepository stateJobRep;
	
	@GetMapping("/preAddJobInterview")
    public String insertJobInterview(Model model) {
		List<Candidate> candidate = candidateRep.findAll();
		List<StateJobInterview> stateJob = stateJobRep.findAll();
		List<Employee> employee = employeeRep.findAll();
		model.addAttribute("candidate", candidate);
		model.addAttribute("stateJob", stateJob);
		model.addAttribute("employee", employee);
        return "addJobInterview";
	} 
	
	@GetMapping("/preSearchByIdJobInterview")
    public String preSearchByIdJobInterview(Model model) {
        return "searchByIdJobInterview";
	} 
	
	@PostMapping("/addJobInterview")
    public String addOrUpdateJobInterview(JobInterview jobInterview, Model model) {
		System.out.println("Sto inserendo/modificando!");
		jobInterviewRep.save(jobInterview);	
        return "loginPage";
    }
		
	@PostMapping("/searchById")
	public String searchById(Model model, Integer idJobInterview) {
		if(jobInterviewRep.findById(idJobInterview).isPresent()) {
		JobInterview jobInterview = (JobInterview)jobInterviewRep.findById(idJobInterview).get();
		model.addAttribute("JobInterviewFound", jobInterview);
		return "updateJobInterview";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/searchByIdEmployee") //funionza test okay!
	public String searchByIdEmployee(Model model, Integer idEmployee) {
		System.out.println("***********id Employee " + idEmployee);
		List<JobInterview> jobInterview = (List<JobInterview>)jobInterviewRep.findByEmployee_idEmployeeOrderByDate(idEmployee);
		model.addAttribute("jobInterviewFound", jobInterview);
		return "employeeJobInterviews";

	}
	
	@PostMapping("/deleteJobInterview")
	public String deleteJobInterview(JobInterview jobInterview, Model model) {
		System.out.println("Sto cancellando!");
		jobInterviewRep.delete(jobInterview);
		return "deleteJobInterviewOk";
	}

}
