package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroConcert;
	@NonNull
	private String nomConcert;
	private LocalDate dateConcert;
	
	@OneToMany(mappedBy = "concert")
	private List<Oeuvre> listeOeuvre;
	
	@ManyToOne
	@JoinColumn(name="idLieu")
	private Lieu lieu;
	
	public Concert(@NonNull String nomConcert, LocalDate dateConcert) {
		super();
		this.nomConcert = nomConcert;
		this.dateConcert = dateConcert;
	}
}
