package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.repository.EmployeeRepository;

@RestController
@CrossOrigin //dovrebbe servire a collegare il rest al FE
@RequestMapping("EmployeeRest") 
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
	
	@GetMapping("/searchByEmailAndPassword")
	public String searchByEmailAndPassword(Model model, String email, String password) {
			System.out.println("Sto facendo il login...");
			System.out.println("Email " + email + " password " + password);
			List<Employee> employeeList=(List<Employee>) employeeRep.findByEmailAndPassword(email, password);
			System.out.println(employeeList.toString());
			if (employeeList != null && !employeeList.isEmpty()) {
		        model.addAttribute("employeeFound", employeeList);
		        return "loginEmployeeOk";
		    } else {
		        return "errorPage";
		    }
	
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteContractType(Employee employee, Model model) { // da testare, anche sugli altri rest
																		//e vedere se sceglie il delete o deleteById
		System.out.println("Sto cancellando la tipologia di contratto!");
		employeeRep.delete(employee);
		return "deleteEmployeeOk";
	}
	
}
