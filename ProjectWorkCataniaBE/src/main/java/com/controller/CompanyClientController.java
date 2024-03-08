package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.CompanyClient;
import com.repository.CompanyClientRepository;

@Controller
@RequestMapping("CompanyClientController")
public class CompanyClientController {
	
	@Autowired
	CompanyClientRepository companyClientRep;
	
	@GetMapping("/preAddCompanyClient")
    public String insertCompanyClient(Model model) {
        return "addCompanyClient";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchByIdCompanyClient(Model model) {
        return "searchByIdCompanyClient";
	} 
	
	
	@GetMapping("/addCompanyClient")
    public String addOrUpdateCompanyClient(CompanyClient companyClient, Model model) {
		System.out.println("Sto inserendo/aggiornando i dati di una azienda!");
		companyClientRep.save(companyClient);	
        return "addCompanyClientOk";
    }
	
	@GetMapping("/searchByIdCompany")
	public String searchByIdCompany(Model model, Integer idCompanyClient) {
		if(companyClientRep.findById(idCompanyClient).isPresent()) {
		CompanyClient companyClient = (CompanyClient)companyClientRep.findById(idCompanyClient).get();
		model.addAttribute("CompanyClientFound", companyClient);
		return "updateCompanyClient";
		} else 
			return "ErrorPage";
	}	
	
	@GetMapping("/deleteCompanyClient")
	public String deleteCompanyClient(CompanyClient companyClient, Model model) {
		System.out.println("Sto cancellando i dati dell'azienda!");
		companyClientRep.delete(companyClient);
		return "deleteCommercialDataOk";
	}
}

