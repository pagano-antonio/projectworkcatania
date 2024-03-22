package com.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.repository.EmployeeRepository;


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
    public String addOrUpdateEmplyee(Employee employee, Model model) {
		System.out.println("Sto inserendo/aggiornando un impiegato!");
		employeeRep.save(employee);	
        return "addEmployeeOk";
    }
	
	@GetMapping("/searchByIdEmployee")
	public String searchByIdContract(Model model, Integer idEmployee) {
		if(employeeRep.findById(idEmployee).isPresent()) {
		Employee employee = (Employee)employeeRep.findById(idEmployee).get();
		model.addAttribute("EmployeeFound", employee);
		return "updateEmployee"; // sulla pagina JSP di aggiorna ci sarà anche il pulsante Elimina
		} else 
			return "ErrorPage";
	}	
	
//			
//			@GetMapping("/searchByEmailAndPassword") // metodo che richiama il JSON dovrebbe essere così, ritornando un oggetto e non una jsp
//			public Employee searchByEmailAndPassword(@RequestParam(value = "email") String email,
//					@RequestParam(value = "password") String password) {
//					System.out.println("Sto facendo il login...");
//					System.out.println("Email " + email + " password " + password);
//					Employee employee = (Employee) employeeRep.findByEmailAndPassword(email, password);
//					return employee;
//					}
	
	 @GetMapping("/searchByEmailAndPassword/{email}/{password}")
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
			
			
	
	@DeleteMapping("/deleteEmployee")
	public String deleteContractType(Employee employee, Model model) { 
		System.out.println("Sto cancellando la tipologia di contratto!");
		employeeRep.delete(employee);
		return "deleteEmployeeOk";
	}
	
}
