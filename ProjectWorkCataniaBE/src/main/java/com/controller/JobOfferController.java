package com.controller;


import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.CompanyClient;
import com.model.ContractType;
import com.model.Employee;
import com.model.EmployeeType;
import com.model.JobOffer;
import com.repository.CompanyClientRepository;
import com.repository.ContractTypeRepository;
import com.repository.JobOfferRepository;

@Controller
//@RequestMapping("JobOfferController")
public class JobOfferController {

	
	@Autowired
	JobOfferRepository jobOffRep;
	
	@Autowired
	ContractTypeRepository contractTypeRep;
	
	@Autowired
	CompanyClientRepository companyClientRep;
	
	@GetMapping("/preJobOfferPage") // per andare nel menù ricerca offerte lavoro
	public String jobOfferPage(Model model) {
		return "jobOffersPage";
	}
	
	
	@GetMapping("/preAddJobOffer") // per pulsante home se ci sarà
    public String insertAddJobOffer(Model  model) {
		List<ContractType> contractType = contractTypeRep.findAll();
		List<CompanyClient> companyClient = companyClientRep.findAll();
		model.addAttribute("contract", contractType);
		model.addAttribute("company", companyClient);
        return "addJobOffer";
	} 
	
	@GetMapping("/preSearchByIdOffer") // potrebbe non servire da controllare le Jsp che servono
    public String preSearchByIdOffer() {
        return "searchByIdOffer";
	} 

	@PostMapping("/addJobOffer")
    public String addOrUpdateJobOffer(JobOffer jobOffer, Model model) {
		System.out.println("Sto inserendo/aggiornando un'offerta di lavoro!");
		jobOffRep.save(jobOffer);	
        return "jobOffersPage";
    }
	
	@GetMapping("/searchByIdOffer")
	public String searchByIdJobOffer(Model model, Integer idJobOffer) {
		if(jobOffRep.findById(idJobOffer).isPresent()) {
		JobOffer jobOffer = (JobOffer)jobOffRep.findById(idJobOffer).get();
		model.addAttribute("JobOfferFound", jobOffer);
		return "updateJobOffer"; // sulla pagina JSP di aggiorna ci sarà anche il pulsante Elimina
		} else 
			return "ErrorPage";
	}	
	
	@GetMapping("/deleteJobOffer")
	public String deleteContractType(JobOffer jobOffer, Model model) { // da testare, anche sugli altri rest
																		//e vedere se sceglie il delete o deleteById
		System.out.println("Sto cancellando l'offerta di lavoro");
		jobOffRep.delete(jobOffer);
		return "deleteEmployeeOk";
	}
	
	@GetMapping("/pageSearchByTitle") //pre-inserimento
	public String searchTitle () {
		return "searchByTitleForm";
	}

	@PostMapping("/searchByTitle")
	public String resultsSearchTitle(Model model, String title) {
	List <JobOffer> search=(List<JobOffer>)jobOffRep.findByTitle(title);
	model.addAttribute("JobOfferByTitle", search);
		return "resultsSearchByJobTitle";	
	}
	
	@GetMapping("/preSearchByRal") 
	public String searchRal (Model model) {
		return "searchRalForm";
	}
	
	@PostMapping("/searchByRal") // test tutto okay, grande wendina!
	public String resultRal (Model model,Integer minRal, Integer maxRal) {
	List <JobOffer>	ralList =(List<JobOffer>)jobOffRep.findByMinRalGreaterThanEqualAndMaxRalLessThanEqual(minRal, maxRal);
	System.out.println(ralList.size());
	model.addAttribute("RalList", ralList);
	return "resultRal";	
	}

	@GetMapping("/searchBetweenDates")
	public String betweenDates (Model model) {
		return "betweenDatesForm";			
	}
	
	@PostMapping("/resultBetweenDates")
	public String resultDates (Model model, Date startDate, Date endDate) {
		List <JobOffer> resultDate = (List <JobOffer>) jobOffRep.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
		model.addAttribute("DateList", resultDate);
		return "resultDate";
	}
}