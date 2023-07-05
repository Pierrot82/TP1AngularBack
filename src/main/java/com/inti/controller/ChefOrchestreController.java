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

import com.inti.model.ChefOrchestre;
import com.inti.model.Soliste;
import com.inti.repository.IChefOrchestreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChefOrchestreController {
	
	@Autowired
	IChefOrchestreRepository icor;
	

	@PostMapping("saveChefOrchestre")
	public boolean saveChefOrchestre(@RequestBody ChefOrchestre chefOrchestre) {
		try {
			icor.save(chefOrchestre);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("listeChefOrchestre")
	public List<ChefOrchestre> listeChefOrchestre() {
		return icor.findAll();
	}
	
	
	@GetMapping("deleteChefOrchestre/{id}")
	public boolean deleteChefOrchestre(@PathVariable("id") int id) {
		
		try {
			ChefOrchestre co = icor.getReferenceById(id);
			System.out.println(co); //permet de déclencher l'exception retourné par getReferenceById()
			icor.delete(co);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	@GetMapping("getChefOrchestre/{id}")
	public ChefOrchestre getChefOrchestre(@PathVariable("id") int id)
	{
		ChefOrchestre co = null;
		try {
			co = icor.findById(id).get();
			return co;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return co;
	}
	
	@PostMapping("modifierChefOrchestre")
	public boolean modifierChefOrchestre(@RequestBody ChefOrchestre chefOrchestre)
	{
		try {
			icor.save(chefOrchestre);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
