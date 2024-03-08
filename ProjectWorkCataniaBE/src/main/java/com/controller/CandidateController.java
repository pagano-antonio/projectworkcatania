package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class CandidateController {   // ricordarsi di fare i nomi e le mappature dei metodi richiamando il termine candidate
	
	
	@GetMapping("/home")
    public String goToHome() {
        return"homePage";  
    }
}
