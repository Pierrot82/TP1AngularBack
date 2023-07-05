package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Lieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeLieu;
	@NonNull
	private String nomLieu;
	private String rue;
	private int nombreFauteuils;
	
	@OneToMany(mappedBy = "lieu")
	private List<Concert> listeConcert;
	
	public Lieu(@NonNull String nomLieu, String rue, int nombreFauteuils) {
		super();
		this.nomLieu = nomLieu;
		this.rue = rue;
		this.nombreFauteuils = nombreFauteuils;
	}


	
}
