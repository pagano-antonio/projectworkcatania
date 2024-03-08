package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.StateJobInterview;
import com.repository.StateJobInterviewRepository;

@Controller
@RequestMapping("StateJobInterviewController")
public class StateJobInterviewController {
	@Autowired
	StateJobInterviewRepository stateJobInterviewRep;
	
	@GetMapping("/preAddJobInterview")
    public String insertAddJobInterview() {
        return "addJobInterview";
	} 
	
	@GetMapping("/preSearchByIdJobInterview") // potrebbe non servire da controllare le Jsp che servono
    public String preSearchByIdJobInterview() {
        return "searchByIdJobInterview";
	} 

	@GetMapping("/addJobInterview")
    public String addOrUpdateJobInterview(StateJobInterview stateJobInterview, Model model) {
		System.out.println("Sto inserendo/aggiornando lo stato del colloquio!");
		stateJobInterviewRep.save(stateJobInterview);	
        return "addJobInterviewOk";
    }
	
	@GetMapping("/searchByIdJobInterview")
	public String searchByIdJobInterview(Model model, Integer idStateJobInterview) {
		if(stateJobInterviewRep.findById(idStateJobInterview).isPresent()) {
		StateJobInterview stateJobInterview = (StateJobInterview)stateJobInterviewRep.findById(idStateJobInterview).get();
		model.addAttribute("StateJobInterviewFound", stateJobInterview);
		return "updateJobInterviewState"; // sulla pagina JSP di aggiorna ci sarà anche il pulsante Elimina
		} else 
			return "ErrorPage";
	}	
	
	@GetMapping("/deleteJobInterview")
	public String deleteContractType(StateJobInterview stateJobInterview, Model model) { // da testare, anche sugli altri rest
																		//e vedere se sceglie il delete o deleteById
		System.out.println("Sto cancellando lo stato del colloquio!");
		stateJobInterviewRep.delete(stateJobInterview);
		return "deleteJobInterviewOk";
	}
}
