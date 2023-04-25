package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Employe extends Personne{

	public Employe() {
		super();
	}

	public Employe(int id, String nom, String prenom, String email, String telephone, String adresse) {
		super(id, nom, prenom, email, telephone, adresse);
	}
	
	public String getKey() throws Exception {
		return "Employe-"+getId();
	}

}
