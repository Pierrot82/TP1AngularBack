package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
public class ChefOrchestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	private double prix;
	private String commentaires;
	
	@OneToMany(mappedBy = "ChefO")
	private List<Oeuvre> listeOeuvre;
  
	
	public ChefOrchestre(String nom, String prenom, LocalDate dateNaissance, String nationalite, double prix,
			String commentaires) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.prix = prix;
		this.commentaires = commentaires;
	}
	
	
}
