package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.CompanyClient;
import com.repository.CompanyClientRepository;

@Controller
//@RequestMapping("CompanyClientController")
public class CompanyClientController {

	@Autowired
	CompanyClientRepository companyClientRep;

	@GetMapping("/preCompaniesPage")
	public String preCompaniesPage() {
		return "companiesPage";
	}

	
	@GetMapping("/preAddCompanyClient")
	public String insertCompanyClient() {
		return "addCompanyClient";
	}

	@GetMapping("/preSearchById")
	public String preSearchByIdCompanyClient(Model model) {
		return "searchByIdCompanyClient";
	}

	@PostMapping("/addCompanyClient")
	public String addOrUpdateCompanyClient(CompanyClient companyClient, Model model) {
		System.out.println("Sto inserendo/aggiornando i dati di una azienda!");
		companyClientRep.save(companyClient);
		return "addCompanyClientOk";
	}

	@PostMapping("/searchByIdCompany")
	public String searchByIdCompany(Model model, Integer idCompanyClient) {
		if (companyClientRep.findById(idCompanyClient).isPresent()) {
			CompanyClient companyClient = (CompanyClient) companyClientRep.findById(idCompanyClient).get();
			model.addAttribute("CompanyClientFound", companyClient);
			return "updateCompanyClient";
		} else
			return "ErrorPage";
	}

	@PostMapping("/deleteCompanyClient")
	public String deleteCompanyClient(CompanyClient companyClient, Model model) {
		System.out.println("Sto cancellando i dati dell'azienda!");
		companyClientRep.delete(companyClient);
		return "deleteCommercialDataOk";
	}

	// Metodo ricerca per nome // da testare //
	@GetMapping("/preSearchCompanyByName")
	public String searchByName() {
		return "SearchCompanyClientByName";
	}

	@PostMapping("/searchCompanyByName")
	public String searchByName(Model model, String name) {
		List<CompanyClient> companyClientList = (List<CompanyClient>) companyClientRep.findByName(name);
		if (companyClientList != null) {
			model.addAttribute("CompanyClientFound", companyClientList);
			return "ListCompanyClientByName";
		} else {
			return "ErrorPage";
		}
	}

	// Metodo ricerca per città // da testare //
	@GetMapping("/preSearchCompanyByCity")
	public String searchByCity() {
		return "searchCompanyByCity";
	}

	@PostMapping("/searchByCity")
	public String searchByCity(Model model, String name) {
		List<CompanyClient> companyClientList = (List<CompanyClient>) companyClientRep.findByCity(name);
		if (companyClientList != null) {
			model.addAttribute("CompanyClientFound", companyClientList);
			return "companyClientByCity";
		} else {
			return "ErrorPage";
		}
	}
	
}
