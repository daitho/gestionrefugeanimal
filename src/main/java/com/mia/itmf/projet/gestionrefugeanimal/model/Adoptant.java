package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Adoptant extends Personne {
	private static int COUNT = 1;
	private final String key;

	
	public Adoptant() {
		super();
		this.key = getClass().getName()+"-"+ COUNT++;
	}
	
	public Adoptant(String nom, String prenom, String email, String telephone, String adresse) {
		super(nom,prenom,email,telephone,adresse);
		this.key = getClass().getName()+"-"+ COUNT++;
	}
	
	public String getKey(){
		return this.key;
	}

}
