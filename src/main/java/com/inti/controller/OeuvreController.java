package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

import lombok.NonNull;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OeuvreController {
	
	@Autowired
	IOeuvreRepository ior;
	

	@PostMapping("saveOeuvre")
	public boolean saveOeuvre(@RequestBody Oeuvre oeuvre) {
		try {
			ior.save(oeuvre);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("listeOeuvre")
	public List<Oeuvre> listeOeuvre() {
		return ior.findAll();
	}
	
	
	@GetMapping("deleteOeuvre/{id}")
	public boolean deleteOeuvre(@PathVariable("id") int id) {
		
		try {
			Oeuvre o = ior.getReferenceById(id);
			System.out.println(o); //permet de déclencher l'exception retourné par getReferenceById()
			ior.delete(o);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	@GetMapping("getOeuvre/{id}")
	public Oeuvre getOeuvre(@PathVariable("id") int id)
	{
		Oeuvre o = null;
		try {
			o = ior.findById(id).get();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@PostMapping("modifierOeuvre")
	public boolean modifierOeuvre(@RequestBody Oeuvre oeuvre)
	{
		try {
			ior.save(oeuvre);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
