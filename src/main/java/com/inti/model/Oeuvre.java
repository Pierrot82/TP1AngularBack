package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString

public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idOeuvre;
	@NonNull
	private String nomOeuvre;
	@NonNull
	private double dureeOeuvre;
	
	@ManyToMany
	@JoinTable(name="oeuvre_soliste",
	joinColumns =@JoinColumn(name="idOeuvre"),
	inverseJoinColumns = @JoinColumn(name="numSoliste"))
	private List<Soliste> listeSoliste;
	
	@ManyToOne
	@JoinColumn(name="numConcert")
	private Concert concert;
	
	@ManyToOne
	@JoinColumn(name="numChefO")
	private ChefOrchestre ChefO;
	
	
	
	public Oeuvre() {}
	
}
