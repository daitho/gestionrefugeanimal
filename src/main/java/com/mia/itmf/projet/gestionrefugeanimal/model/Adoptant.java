package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Adoptant extends Personne {

	
	public Adoptant() {
		super();
	}
	
	public Adoptant(int id, String nom, String prenom, String email, String telephone, String adresse) {
		super(id,nom,prenom,email,telephone,adresse);
	}
	
	public String getKey() throws Exception {
		return "Adoptant-"+getId();
	}

}
