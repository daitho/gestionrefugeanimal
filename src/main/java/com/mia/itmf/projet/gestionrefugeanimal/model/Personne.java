
package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Personne {
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	
	public enum Critere{
		NOM,PRENOM,EMAIL;
	}

	public Personne() {
	}
	
	public Personne(String nom, String prenom, String email, String telephone, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	public abstract String getKey();
	
	public String getNom() {
		return nom;
	}


	protected void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	protected void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	protected void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAdresse() {
		return adresse;
	}


	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Personne [id=" + getKey() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", email=" + getEmail() + ", telephone="
				+ getTelephone() + ", adresse=" + getAdresse() + "]";
	}
	
	
	
	

}
