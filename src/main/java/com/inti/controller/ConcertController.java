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

import com.inti.model.Concert;
import com.inti.model.Soliste;
import com.inti.repository.IConcertRepository;

@Controller
@RequestMapping("concert")
public class ConcertController {
	
	@Autowired
	IConcertRepository icr;
	
	@GetMapping("creerConcert")
	public String formConcert() {
		return "creerConcert";
	}

	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("concert") Concert s) {
		icr.save(s);
		return "redirect:/concert/listeConcert";
	}

	@GetMapping("listeConcert")
	public String listeConcert(Model m) {
		m.addAttribute("listeConcert", icr.findAll().toArray());
		return "listeConcert";
	}
	@GetMapping("deleteConcert/{numeroConcert}")
	public String deleteConcert(@PathVariable("numeroConcert") int numeroConcert) {
		icr.deleteById(numeroConcert);
		return "redirect:/concert/listeConcert";
	}
	

	@GetMapping("modifierConcert/{numeroConcert}")
	public String modifierConcert(@PathVariable("numeroConcert") int numeroConcert, Model m)
	{
		m.addAttribute("concert", icr.findById(numeroConcert).get());
		return "modifierConcert";
	}
	
	@PostMapping("modifierConcert/updateConcert")
	public String updateConcert(@ModelAttribute("concert") Concert s)
	{
		icr.save(s);
		return "redirect:/concert/listeConcert";
	}
	
	
	@GetMapping("getConcert/{numeroConcert}")
	public String getConcert(@PathVariable("numeroConcert") int numeroConcert, Model m)
	{
		m.addAttribute("c1", icr.findById(numeroConcert).get());
		
		return "getConcert";
	}
	

}
