package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.repository.EmployeeRepository;

@RestController
@RequestMapping("EmployeeRest") // tutto da testare
public class EmployeeRest {
	
	@Autowired
	EmployeeRepository employeeRep;
	
	@GetMapping("/preEmployee")
    public String insertEmployee() {
        return "addEmployee";
	} 
	
	@GetMapping("/preSearchByIdEmployee") // potrebbe non servire da controllare le Jsp che servono
    public String preSearchByIdEmployee() {
        return "searchByIdEmployee";
	} 

	@GetMapping("/addEmployee")
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
	
	@GetMapping("/deleteEmployee")
	public String deleteContractType(Employee employee, Model model) { // da testare, anche sugli altri rest
																		//e vedere se sceglie il delete o deleteById
		System.out.println("Sto cancellando la tipologia di contratto!");
		employeeRep.delete(employee);
		return "deleteEmployeeOk";
	}
	
}
