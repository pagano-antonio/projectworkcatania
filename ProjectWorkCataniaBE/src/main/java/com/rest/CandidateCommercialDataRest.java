package com.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CandidateCommercialData;
import com.repository.CandidateCommercialDataRepository;

@RestController
@RequestMapping("CandidateCommercialDataRest") // tutto da testare
public class CandidateCommercialDataRest {
	@Autowired
	CandidateCommercialDataRepository candidateCommercialDataRep;
	
	
	@GetMapping("/preAddCandidateCommercialData") 
    public String insertCandidateCommercialData() {
        return "addCandidateCommercialData";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchByIdCommercialData() {
        return "searchByIdCommercialData";
	} 
	
	
	@PostMapping("/addCandidateCommercialData")
    public String addOrUpdateCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto inserendo/aggiornando i dati commerciali di un candidato!");
		candidateCommercialDataRep.save(candidateCommercialData);	
        return "addCandidateCommercialDataOk";
    }
	
	@GetMapping("/searchByIdCommercialData")
	public String searchByIdCommercialData(Model model, Integer id) {
		if(candidateCommercialDataRep.findById(id).isPresent()) {
		CandidateCommercialData commercialData = candidateCommercialDataRep.findById(id).get();
		model.addAttribute("CommercialDataFound", commercialData);
		return "updateCandidateCommercialData";
		} else 
			return "ErrorPage";
	}	
	
	@DeleteMapping("/deleteCommercialData")
	public String deleteCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto cancellando i dati commerciali!");
		candidateCommercialDataRep.delete(candidateCommercialData);
		return "deleteCommercialDataOk";
	}
	
	
	
}
