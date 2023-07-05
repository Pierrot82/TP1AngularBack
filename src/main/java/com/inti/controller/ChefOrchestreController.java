package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.ChefOrchestre;
import com.inti.model.Soliste;
import com.inti.repository.IChefOrchestreRepository;

@Controller
@RequestMapping("chef_orchestre")
public class ChefOrchestreController {
	
	@Autowired
	IChefOrchestreRepository icor;
	
	@GetMapping("creerChefOrchestre")
	public String formChefOrchestre() {
		return "creerChefOrchestre";
	}

	@PostMapping("saveChefOrchestre")
	public String saveChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre co) {
		icor.save(co);
		return "redirect:/chef_orchestre/listeChefOrchestre";
	}

	@GetMapping("listeChefOrchestre")
	public String listeChefOrchestre(Model m) {
		m.addAttribute("listeChefOrchestre", icor.findAll().toArray());
		return "listeChefOrchestre";
	}
	@GetMapping("deleteChefOrchestre/{id}")
	public String deleteChefOrchestre(@PathVariable("id") int id) {
		icor.deleteById(id);
		return "redirect:/chef_orchestre/listeChefOrchestre";

	}	
	
	@GetMapping("modifierChefOrchestre/{id}")
	public String modifierChefOrchestre(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("chefOrchestre", icor.findById(id).get());
		return "modifierChefOrchestre";
	}
	
	@PostMapping("modifierChefOrchestre/updateChefOrchestre")
	public String updateChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre co)
	{
		icor.save(co);
		return "redirect:/chef_orchestre/listeChefOrchestre";
	}
	
}
