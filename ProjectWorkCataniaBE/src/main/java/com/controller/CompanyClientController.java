package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/preSearchName")
	public String searchByName(Model model) {
		return "companyClientByName";
	}

	@PostMapping("/searchByName")
	public String searchByName(Model model, String name) {
		List<CompanyClient> companyClientList = (List<CompanyClient>) companyClientRep.findByName(name);
		if (companyClientList != null) {
			model.addAttribute("CompanyClientFound", companyClientList);
			return "companyClientByName";
		} else {
			return "ErrorPage";
		}
	}

	@PostMapping("/companyClientByName")
	public String searchByName(Model model, CompanyClient c) {
		System.out.println("Sto effettuando la ricerca...");
		companyClientRep.save(c);
		return "companyClientByName";
	}

	// Metodo ricerca per città // da testare //
	@GetMapping("/preSearchCity")
	public String searchByCity(Model model) {
		return "searchByCity";
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

	@PostMapping("/companyClientByCity")
	public String searchByCity(Model model, CompanyClient c) {
		System.out.println("Sto effettuando la ricerca...");
		companyClientRep.save(c);
		return "companyClientByCity";
	}

}
