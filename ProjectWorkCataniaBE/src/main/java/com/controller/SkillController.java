package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Skill;
import com.repository.SkillRepository;

@Controller
@RequestMapping("SkillController")
public class SkillController {


	@Autowired
	SkillRepository skillRep;
	
	
	@GetMapping("/preAddSkill")
    public String insertSkill(Model model) {
        return "addSkill";
	} 
	
	@GetMapping("/preSearchByIdSkill")
    public String preSearchByIdSkill(Model model) {
        return "searchByIdSkill";
	} 
	
	@PostMapping("/addSkill")
    public String addOrUpdateSkill(Skill skill, Model model) {
		System.out.println("Sto inserendo/modificando!");
		skillRep.save(skill);	
        return "loginPage";
    }
		
	@PostMapping("/searchById")
	public String searchById(Model model, Integer idSkill) {
		if(skillRep.findById(idSkill).isPresent()) {
		Skill skill = (Skill)skillRep.findById(idSkill).get();
		model.addAttribute("SkillFound", skill);
		return "updateSkill";
		} else 
			return "ErrorPage";
	}
	
	@GetMapping("/preSearchSkillByTitle")
    public String preSearchSkillByTitle(Model model) {
        return "searchSkillsByTitle";
	} 
	
	@PostMapping("/searchByTitle")
	public String searchByTitle(Model model, String title) {
		List <Skill>skill = (List<Skill>)skillRep.findByTitle(title);
		model.addAttribute("SkillFound", skill);
		return "listOfSkills";
	}
	
	@PostMapping("/deleteSkill")
	public String deleteSkill(Skill skill, Model model) {
		System.out.println("Sto cancellando!");
		skillRep.delete(skill);
		return "deleteSkillOk";
	}
}
