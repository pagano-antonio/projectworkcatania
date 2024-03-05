package com.model.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.EmployeeType;
import com.model.repository.EmployeeTypeRepository;

@RestController
@RequestMapping("EmployeeTypeRest")
public class EmployeeTypeRest {

	@Autowired
	EmployeeTypeRepository employeeTypeRep;
	
	
	@GetMapping("/preAddEmployeeType")
    public String insertEmployeeType(Model model) {
        return "addEmployeeType";
	} 
	
	@GetMapping("/preSearchById")
    public String preSearchById(Model model) {
        return "searchById";
	} 
	
	@GetMapping("/addEmployeeType")
    public String addOrUpdateEmployeeType(EmployeeType employeeType, Model model) {
		System.out.println("Sto inserendo/modificando un candidato!");
		employeeTypeRep.save(employeeType);	
        return "addEmployeeTypeOk";
    }
		
	@GetMapping("/searchById")
	public String searchById(Model model, Integer id) {
		if(employeeTypeRep.findById(id).isPresent()) {
		EmployeeType employeeType = (EmployeeType)employeeTypeRep.findById(id).get();
		model.addAttribute("EmployeeTypeFound", employeeType);
		return "updateCandidate";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/deleteEmployeeType")
	public String deleteCandidate(EmployeeType employeeType, Model model) {
		System.out.println("Sto cancellando il candidato!");
		employeeTypeRep.delete(employeeType);
		return "deleteCandidateOk";
	}
}
