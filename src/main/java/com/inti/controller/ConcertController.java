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


import com.inti.model.Concert;
import com.inti.model.Soliste;
import com.inti.repository.IConcertRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConcertController {
	
	@Autowired
	IConcertRepository icr;
	

	@PostMapping("saveConcert")
	public boolean saveConcert(@RequestBody Concert concert) {
		try {
			icr.save(concert);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("listeConcert")
	public List<Concert> listeConcert() {
		return icr.findAll();
	}
	
	
	@GetMapping("deleteConcert/{id}")
	public boolean deleteConcert(@PathVariable("id") int id) {
		
		try {
			Concert c = icr.getReferenceById(id);
			System.out.println(c); //permet de déclencher l'exception retourné par getReferenceById()
			icr.delete(c);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	@GetMapping("getConcert/{id}")
	public Concert getConcert(@PathVariable("id") int id)
	{
		Concert c = null;
		try {
			c = icr.findById(id).get();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@PostMapping("modifierConcert")
	public boolean modifierConcert(@RequestBody Concert concert)
	{
		try {
			icr.save(concert);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
