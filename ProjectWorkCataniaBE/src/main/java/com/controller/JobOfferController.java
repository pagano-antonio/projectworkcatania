package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.JobOffer;
import com.repository.JobOfferRepository;

@Controller
//@RequestMapping("JobOfferController")
public class JobOfferController {

	
	@Autowired
	JobOfferRepository jobOffRep;
	
	@GetMapping("/pageSearchByTitle") //pre-inserimento
	public String searchTitle (Model model) {
		return "searchByTitleForm";
	}
	
	@PostMapping("/pageResultsSearch")
	public String resultsSearchTitle(Model model, String title) {
	List <JobOffer> search=(List<JobOffer>)jobOffRep.findByTitle(title);
	model.addAttribute("JobOfferByTitle", search);
		return "resultsSearchByJobTitle";	
	}
	
	@GetMapping("/pageSearchRal") 
	public String searchRal (Model model) {
		return "searchRalForm";
	}
	
	@PostMapping("/pageResultRal") // test tutto okay, grande wendina!
	public String resultRal (Model model,Integer minRal, Integer maxRal) {
	List <JobOffer>	ralList =(List<JobOffer>)jobOffRep.findByMinRalGreaterThanEqualAndMaxRalLessThanEqual(minRal, maxRal);
	System.out.println(ralList.size());
	model.addAttribute("RalList", ralList);
	return "resultRal";	
	}


}