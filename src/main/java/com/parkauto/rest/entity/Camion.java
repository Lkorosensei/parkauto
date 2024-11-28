package com.parkauto.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="camion")
public class Camion extends Vehicule {
	
	@Override
	public String demarrer() {
		return"BRRRRRRR !!!";
	}
	
	@Override
	public String accelerer() {
		return "BRRROOOOOUM !!!";
	}

	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camion(Long matricule, int anneeModel, double prix) {
		super(matricule, anneeModel, prix);
		// TODO Auto-generated constructor stub
	}
	
	
}
