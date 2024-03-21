package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	} 
	
	
	@PostMapping("/addCandidateCommercialData")
    public String addOrUpdateCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto inserendo/aggiornando i dati commerciali di un candidato!");
		candidateCommercialDataRep.save(candidateCommercialData);	
        return "addCandidateCommercialDataOk";
    }
	
	@PostMapping("/searchByIdCommercialData")
	public String searchByIdCommercialData(Model model, Integer id) {
//		AtomicReference<String> response = new AtomicReference<>("ErrorPage");
//		candidateCommercialDataRep.findById(id).ifPresent( commercialData -> {
//			model.addAttribute("CommercialDataFound", commercialData);
//			response.set("updateCandidateCommercialData");
//		});
//		return response.get();


		if(candidateCommercialDataRep.existsById(id)) {
		CandidateCommercialData commercialData = candidateCommercialDataRep.findById(id).get();
		model.addAttribute("CommercialDataFound", commercialData);
		return "updateCandidateCommercialData";
		} else 
			return "ErrorPage";
	}	
	
	@PostMapping("/deleteCommercialData")
	public String deleteCommercialData(CandidateCommercialData candidateCommercialData, Model model) {
		System.out.println("Sto cancellando i dati commerciali!");
		candidateCommercialDataRep.delete(candidateCommercialData);
		return "deleteCommercialDataOk";
	}
	

	@PostMapping("/searchCommercialDataByIdCandidate")
	public String searchByIdCandidate(Model model, Integer idCandidate) {
		List<CandidateCommercialData> candidateList = candidateCommercialDataRep.findByCandidate_idCandidate(idCandidate);
		System.out.println("Ho trovato l'id Candidato: " + idCandidate);
		model.addAttribute("commercial", candidateList);
		System.out.println(candidateList);
		return "candidateListByCity";
	}
}
