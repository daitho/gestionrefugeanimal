
package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionEmploye;

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


	protected boolean setEmail(String email) throws ExceptionEmploye {
		
		if(isEmailAdress(email)) {
			this.email = email;
			return true;
		}
		
		throw new ExceptionEmploye("L'email "+email+" est incorrect");
	}

    public boolean isEmailAdress(String email) {
        Pattern parttern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher matcher = parttern.matcher(email.toUpperCase());
        
        return matcher.matches();
    }

	public String getTelephone() {
		return telephone;
	}


	protected void setTelephone(String telephone) {
		// Expression régulière pour un entier
		String pattern = "^-?\\d+$";

		// Vérification de la correspondance avec l'expression régulière
		if (Pattern.matches(pattern, telephone)) {
			if(telephone.length() == 10 || telephone.length() == 13) {
				this.telephone = telephone;
			}else {
				System.err.println("La numéro de téléphone "+telephone+" n'est pas correct !.");
			}
		} else {
				System.err.println("La numéro de téléphone "+telephone+" n'est pas un entier.");
		}
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
