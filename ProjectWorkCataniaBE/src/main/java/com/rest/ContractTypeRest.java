package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ContractType;
import com.repository.ContractTypeRepository;

@RestController
@RequestMapping("ContractTypeRest") // tutto da testare
public class ContractTypeRest {
	
	@Autowired
	ContractTypeRepository contractTypeRep;

	
	@GetMapping("/preAddContractType")
    public String insertContractType(Model model) {
        return "addContractType";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchByIdContractType(Model model) {
        return "searchByIdContractType";
	} 
	
	
	@PostMapping("/addContractType")
    public String addOrUpdateContractType(ContractType contractType, Model model) {
		System.out.println("Sto inserendo/aggiornando una tipologia di contratto!");
		contractTypeRep.save(contractType);	
        return "addContractTypeOk";
    }
	
	@GetMapping("/searchByIdContract")
	public String searchByIdContract(Model model, Integer idContractType) {
		if(contractTypeRep.findById(idContractType).isPresent()) {
		ContractType contractType = (ContractType)contractTypeRep.findById(idContractType).get();
		model.addAttribute("ContractDataFound", contractType);
		return "updateContractType";
		} else 
			return "ErrorPage";
	}	
	
	@DeleteMapping("/deleteContractType")
	public String deleteContractType(ContractType contractType, Model model) {
		System.out.println("Sto cancellando la tipologia di contratto!");
		contractTypeRep.delete(contractType);
		return "deleteContractTypeOk";
	}
}
