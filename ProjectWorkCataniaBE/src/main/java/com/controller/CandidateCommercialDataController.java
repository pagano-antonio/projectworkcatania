package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Candidate;
import com.model.CandidateCommercialData;
import com.repository.CandidateCommercialDataRepository;


@Controller
@RequestMapping("CandidateCommercialDataController")
public class CandidateCommercialDataController {
	@Autowired
	CandidateCommercialDataRepository candidateCommercialDataRep;

	@GetMapping("/preAddCandidateCommercialData") // questi se non funzionano sono da spostare sui controller Normali
    public String insertCandidateCommercialData() {
        return "addCandidateCommercialData";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchByIdCommercialData() {
        return "searchByIdCommercialData";
	} // i PRE se non funzionano vanno spostati in controller come il metodo HOME che deve stare in controller
	
	
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
	public String searchByIdCandidate(Model model, Integer idCandidateCommercial) {
		List<CandidateCommercialData> candidateList = (List<CandidateCommercialData>)candidateCommercialDataRep.findByIdCandidateCommercial(idCandidateCommercial);
		System.out.println("Ho trovato l'id Candidato: " + idCandidateCommercial);
		model.addAttribute("candidateList", candidateList);
		System.out.println(candidateList);
		return "resultsIdCandidate";
	}
}
