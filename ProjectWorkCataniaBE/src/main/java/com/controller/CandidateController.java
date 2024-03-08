package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("candidateController")
public class CandidateController {
	
	
	@GetMapping("/home")
    public String goToHome() {
        return"homePage";  
    }
}
