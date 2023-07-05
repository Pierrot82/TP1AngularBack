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

import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LieuController {
	
	@Autowired
	ILieuRepository ilr;
	

	@PostMapping("saveLieu")
	public boolean saveLieu(@RequestBody Lieu lieu) {
		try {
			ilr.save(lieu);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("listeLieu")
	public List<Lieu> listelieu() {
		return ilr.findAll();
	}
	
	
	@GetMapping("deleteLieu/{id}")
	public boolean deleteLieu(@PathVariable("id") int id) {
		
		try {
			Lieu l = ilr.getReferenceById(id);
			System.out.println(l); //permet de déclencher l'exception retourné par getReferenceById()
			ilr.delete(l);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	@GetMapping("getLieu/{id}")
	public Lieu getLieu(@PathVariable("id") int id)
	{
		Lieu l = null;
		try {
			l = ilr.findById(id).get();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	@PostMapping("modifierLieu")
	public boolean modifierLieu(@RequestBody Lieu lieu)
	{
		try {
			ilr.save(lieu);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
