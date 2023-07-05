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

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

import lombok.NonNull;

@Controller
@RequestMapping("oeuvre")
public class OeuvreController {
	
	@Autowired
	IOeuvreRepository ior;
	
	@GetMapping("creerOeuvre")
	public String formOeuvre() {
		return "creerOeuvre";
	}

	@PostMapping("creerOeuvre")
	public String saveOeuvre(@ModelAttribute("oeuvre") Oeuvre o) {
		ior.save(o);
		return "redirect:/oeuvre/listeOeuvre";
	}

	@GetMapping("listeOeuvre")
	public String listeOeuvre(Model m) {
		m.addAttribute("listeOeuvre", ior.findAll().toArray());
		return "listeOeuvre";
	}

	
	@GetMapping("deleteOeuvre/{id}")
	public String deleteOeuvre(@PathVariable("id") int id) {
		ior.deleteById(id);
		return "redirect:/oeuvre/listeOeuvre";
	}
	
	@GetMapping("modifierOeuvre/{id}")
	public String modifierOeuvre(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("oeuvre", ior.findById(id).get());
		return "modifierOeuvre";
	}
	
	@PostMapping("modifierOeuvre")
	public String updateOeuvre(@ModelAttribute("oeuvre") Oeuvre o)
	{
		ior.save(o); // = saveOrUpdate
		return "redirect:/oeuvre/listeOeuvre";
	}
	

	
	@GetMapping("getOeuvre/{idOeuvre}")
	public String getConcert(@PathVariable("idOeuvre") int idOeuvre, Model m)
	{
		m.addAttribute("o1", ior.findById(idOeuvre).get());
		
		return "getOeuvre";
	}
	

}
