package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.JobOffer;
import com.repository.JobOfferRepository;

@RestController
@RequestMapping("JobOfferRest")
public class JobOfferRest {
	@Autowired
	JobOfferRepository jobOfferRep;
	
	@GetMapping("/preAddJobOffer") // per pulsante home se ci sarà
    public String insertAddJobOffer() {
        return "addJobOffer";
	} 
	
	@GetMapping("/preSearchByIdOffer") // potrebbe non servire da controllare le Jsp che servono
    public String preSearchByIdOffer() {
        return "searchByIdOffer";
	} 

	@PostMapping("/addJobOffer")
    public String addOrUpdateJobOffer(JobOffer jobOffer, Model model) {
		System.out.println("Sto inserendo/aggiornando un'offerta di lavoro!");
		jobOfferRep.save(jobOffer);	
        return "addJobOfferOk";
    }
	
	@GetMapping("/searchByIdOffer")
	public String searchByIdJobOffer(Model model, Integer idJobOffer) {
		if(jobOfferRep.findById(idJobOffer).isPresent()) {
		JobOffer jobOffer = (JobOffer)jobOfferRep.findById(idJobOffer).get();
		model.addAttribute("JobOfferFound", jobOffer);
		return "updateJobOffer"; 
		} else 
			return "ErrorPage";
	}	
	
	@DeleteMapping("/deleteJobOffer")
	public String deleteContractType(JobOffer jobOffer, Model model) { // da testare, anche sugli altri rest
																		//e vedere se sceglie il delete o deleteById
		System.out.println("Sto cancellando l'offerta di lavoro");
		jobOfferRep.delete(jobOffer);
		return "deleteEmployeeOk";
	}
	
	
}
