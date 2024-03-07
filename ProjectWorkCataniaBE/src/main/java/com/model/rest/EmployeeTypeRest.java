package com.model.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.EmployeeType;
import com.model.repository.EmployeeTypeRepository;

@RestController
@RequestMapping("EmployeeTypeRest") // tutto da testare
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
		System.out.println("Sto inserendo/modificando!");
		employeeTypeRep.save(employeeType);	
        return "addEmployeeTypeOk";
    }
		
	@GetMapping("/searchById")
	public String searchById(Model model, Integer idEmployeeType) {
		if(employeeTypeRep.findById(idEmployeeType).isPresent()) {
		EmployeeType employeeType = (EmployeeType)employeeTypeRep.findById(idEmployeeType).get();
		model.addAttribute("EmployeeTypeFound", employeeType);
		return "updateEmployeeType";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/deleteEmployeeType")
	public String deleteEmployeeType(EmployeeType employeeType, Model model) {
		System.out.println("Sto cancellando!");
		employeeTypeRep.delete(employeeType);
		return "deleteEmployeeTypeOk";
	}
}