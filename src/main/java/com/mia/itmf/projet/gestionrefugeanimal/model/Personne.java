package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;

	public Personne() {
	}
	
	public Personne(int id, String nom, String prenom, String email, String telephone, String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	public String getKey() throws Exception {
		throw new Exception("La methode getKey doit être surcharger");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", adresse=" + adresse + "]";
	}
	
	
	
	

}
