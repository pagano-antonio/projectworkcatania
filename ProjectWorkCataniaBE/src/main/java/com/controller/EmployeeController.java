package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.model.Employee;
import com.model.EmployeeType;
import com.repository.EmployeeRepository;
import com.repository.EmployeeTypeRepository;

@Controller
//@RequestMapping("EmployeeController")
public class EmployeeController {


	@Autowired
	EmployeeRepository employeeRep;
	
	@Autowired
	EmployeeTypeRepository employeeTypeRep;
	
	@GetMapping("/preEmployee")
    public String insertEmployee() {
        return "addEmployee";
	} 
	
	@GetMapping("/preSignUp")
    public String preSignUp(Model model){//metodo che porta alla pagina di iscrizione 
		List<EmployeeType> employeeType = employeeTypeRep.findAll();
		List<Employee> employee = employeeRep.findAll();
		model.addAttribute("descriptions", employeeType);
		model.addAttribute("employee", employee);
		return "signUpPage";
	} 
	
	
	@GetMapping("/preUpdateEmployee")
	public String preUpdateEmployee(Model model, @RequestParam("idEmployee") Integer idEmployee) {
	    List<EmployeeType> employeeType = employeeTypeRep.findAll();
	    Employee employeeToUpdate = employeeRep.findById(idEmployee).orElse(null); // retrieve the Employee object with the given id
	    model.addAttribute("descriptions", employeeType);
	    model.addAttribute("employeeToUpdate", employeeToUpdate); // add the Employee object to the model
	    return "updateEmployee";
	}
	
	@GetMapping("/preSearchByIdEmployee") // potrebbe non servire da controllare le Jsp che servono
    public String preSearchByIdEmployee() {
        return "searchByIdEmployee";
	} 

	@PostMapping("/addEmployee")
    public String addOrUpdateEmplyee(Employee employee, Model model) {
		System.out.println("Sto inserendo/aggiornando un impiegato!");
		employeeRep.save(employee);
        return "loginPage";
    }
	
	@PostMapping("/searchByIdEmployee")
	public String searchByIdContract(Model model, Integer idEmployee) {
		if(employeeRep.findById(idEmployee).isPresent()) {
		Employee employee = (Employee)employeeRep.findById(idEmployee).get();
		model.addAttribute("EmployeeFound", employee);
		return "updateEmployee"; // sulla pagina JSP di aggiorna ci sarà anche il pulsante Elimina
		} else 
			return "ErrorPage";
	}	
	
	@PostMapping("/searchByEmailAndPassword")
	public String searchByEmailAndPassword(Model model, String email, String password) {
			System.out.println("Sto facendo il login...");
			System.out.println("Email " + email + " password " + password);
			List<Employee> employeeList =(List<Employee>) employeeRep.findByEmailAndPassword(email, password);
		    System.out.println(employeeList.toString());
		    model.addAttribute("employeeFound",employeeList);
		    return "loginEmployeeOk";
	}
	
	
	@GetMapping("/deleteEmployee")
	public String deleteContractType(Employee employee, Model model) { 
		System.out.println("Sto cancellando la tipologia di contratto!");
		employeeRep.delete(employee);
		return "loginPage";
	}
	
}
