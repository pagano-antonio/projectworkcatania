package com.model.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CandidateCommercialData;
import com.model.repository.CandidateCommercialDataRepository;

@RestController
@RequestMapping("CandidateCommercialDataRest")
public class CandidateCommercialDataRest {
	@Autowired
	CandidateCommercialDataRepository candidateCommercialDataRep;
	
	
	@GetMapping("/preAddCandidateCommercialData")
    public String insertCandidateCommercialData(Model model) {
        return "addCandidateCommercialData";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchByIdCommercialData(Model model) {
        return "searchByIdCommercialData";
	} 
	
	
	@GetMapping("/addCandidateCommercialData")
    public String addOrUpdateCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto inserendo/aggiornando i dati commerciali di un candidato!");
		candidateCommercialDataRep.save(candidateCommercialData);	
        return "addCandidateCommercialDataOk";
    }
	
	@GetMapping("/searchByIdCommercialData")
	public String searchByIdCommercialData(Model model, Integer id) {
		if(candidateCommercialDataRep.findById(id).isPresent()) {
		CandidateCommercialData commercialData = (CandidateCommercialData)candidateCommercialDataRep.findById(id).get();
		model.addAttribute("CommercialDataFound", commercialData);
		return "updateCandidateCommercialData";
		} else 
			return "ErrorPage";
	}	
	
	@GetMapping("/deleteCommercialData")
	public String deleteCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto cancellando i dati commerciali!");
		candidateCommercialDataRep.delete(candidateCommercialData);
		return "deleteCommercialDataOk";
	}
	
	@GetMapping("/searchCommercialDataByIdCandidate")
	public String searchByIdCandidate(Model model, Integer idCandidate) {
		List<CandidateCommercialData> candidateList = (List<CandidateCommercialData>)candidateCommercialDataRep.findByCandidate_id(idCandidate);
		System.out.println("Ho trovato l'id Canidato: " + idCandidate);
		model.addAttribute("candidateList", candidateList);
		System.out.println(candidateList);
		return "ResultsIdCandidate";
	}
	
}
