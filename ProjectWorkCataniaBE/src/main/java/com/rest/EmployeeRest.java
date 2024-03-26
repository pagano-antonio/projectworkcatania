package com.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.model.EmployeeType;
import com.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/EmployeeRest")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRest {
	
	@Autowired
	EmployeeRepository employeeRep;
	
	@GetMapping("/preEmployee")
    public String insertEmployee() {
        return "addEmployee";
	} 
	
	@GetMapping("/preSearchByIdEmployee") 
    public String preSearchByIdEmployee() {
        return "searchByIdEmployee";
	} 
	
	
	@PostMapping("/addEmployee")
    public Employee addOrUpdateEmployee(@RequestBody Employee employee ) { 
		System.out.println("Sto inserendo/aggiornando un impiegato!");
		employee = employeeRep.save(employee);	
        return employee;
    }
	
	
	@GetMapping("/searchByIdEmployee")
	public String searchByIdContract(Model model, Integer idEmployee) {
		if(employeeRep.findById(idEmployee).isPresent()) {
		Employee employee = (Employee)employeeRep.findById(idEmployee).get();
		model.addAttribute("EmployeeFound", employee);
		return "updateEmployee"; 
		} else 
			return "ErrorPage";
	}	
			
	 @GetMapping("/searchByEmailAndPassword/{email}/{password}") // metodo rest per collegarci ad Angular con Response Entity
	    public ResponseEntity<Employee> searchByEmailAndPassword(
	            @PathVariable("email") String email,
	            @PathVariable("password") String password) {
		 		System.out.println("Sto facendo il login...");
	        Employee employee = employeeRep.findByEmailAndPassword(email, password).get(0);
	        if (employee != null) {
	            return ResponseEntity.ok(employee); 
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
    }		
				
//	@GetMapping("/searchByEmailAndPassword/{email}/{password}") // metodo di ricerca con eccezione e che ritorna 
//	public Employee searchByEmailAndPassword( //solo employee e non Response Entity
//	    @PathVariable("email") String email,
//	    @PathVariable("password") String password) {
//	    Employee employee = employeeRep.findByEmailAndPassword(email, password).get(0);
//	    if (employee != null) {
//	        return employee;
//	    } else {
//	        throw new EntityNotFoundException("Employee not found with email " + email);
//	    }
//	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteContractType(Employee employee, Model model) { 
		System.out.println("Sto cancellando la tipologia di contratto!");
		employeeRep.delete(employee);
		return "deleteEmployeeOk";
	}
	
}
