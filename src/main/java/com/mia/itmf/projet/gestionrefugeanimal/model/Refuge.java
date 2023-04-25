package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Refuge {
	private int id;
	private String localisation;
	private int nombreAnimal;
	
	public Refuge() {
		super();
	}

	public Refuge(int id, String localisation, int nombreAnimal) {
		super();
		this.id = id;
		this.localisation = localisation;
		this.nombreAnimal = nombreAnimal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getNombreAnimal() {
		return nombreAnimal;
	}

	public void setNombreAnimal(int nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}
	
	

}
