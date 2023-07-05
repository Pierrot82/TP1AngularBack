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

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SolisteController {
	
	@Autowired
	ISolisteRepository isr;
	

	@PostMapping("saveSoliste")
	public boolean saveSoliste(@RequestBody Soliste soliste) {
		try {
			isr.save(soliste);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("listeSoliste")
	public List<Soliste> listesoliste() {
		return isr.findAll();
	}
	
	
	@GetMapping("deleteSoliste/{id}")
	public boolean deleteSoliste(@PathVariable("id") int id) {
		
		try {
			Soliste s = isr.getReferenceById(id);
			System.out.println(s); //permet de déclencher l'exception retourné par getReferenceById()
			isr.delete(s);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	@GetMapping("getSoliste/{id}")
	public Soliste getSoliste(@PathVariable("id") int id)
	{
		Soliste s = null;
		try {
			s = isr.findById(id).get();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@PostMapping("modifierSoliste")
	public boolean modifierSoliste(@RequestBody Soliste soliste)
	{
		try {
			isr.save(soliste);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
