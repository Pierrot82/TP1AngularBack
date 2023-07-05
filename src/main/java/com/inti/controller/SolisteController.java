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

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@Controller
@RequestMapping("/soliste")
public class SolisteController {
	
	@Autowired
	ISolisteRepository isr;
	
	@GetMapping("creerSoliste")
	public String formSoliste() {
		return "creerSoliste";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste s) {
		isr.save(s);
		return "redirect:/soliste/listeSoliste";
	}

	@GetMapping("listeSoliste")
	public String listeSoliste(Model m) {
		m.addAttribute("listeS", isr.findAll().toArray());
		return "listeSoliste";
	}
	
	@GetMapping("deleteSoliste/{num}")
	public String deleteSoliste(@PathVariable("num") int num) {
		isr.deleteById(num);

		return "redirect:/soliste/listeSoliste";
	}
	
	@GetMapping("modifierSoliste/{num}")
	public String modifSoliste(@PathVariable("num") int num, Model m) {
		m.addAttribute("soliste", isr.getReferenceById(num));

		return "modifierSoliste";
	}
	
	@PostMapping("modifierSoliste/updateSoliste")
	public String updateSoliste(@ModelAttribute("soliste") Soliste s)
	{
		isr.save(s);
		return "redirect:/soliste/listeSoliste";
	}
	

}
