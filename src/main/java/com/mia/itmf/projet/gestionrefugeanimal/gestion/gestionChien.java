package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;

public class gestionChien extends GestionAnimal {
	
	public boolean verifierChien(Chien chien) {
		return super.verifierAnimal(chien);
	}
	
	public boolean ajouterChien(Chien chien) {
		if(super.ajouterAnimal(chien)) {
			return true;
		}
		return false;
	}
	
	public boolean suprimerChien(Chien chien) throws Exception {
		if(super.supprimerAnimal(chien)) {
			return true;
		}
		return false;
	}
	
	public boolean miseAJourChien(Chien chien) throws Exception {
		return super.miseAJourAnimal(chien);
	}
	
	public Chien retrouverChien(int key) {
		return (Chien) super.retrouverAnimal(getKey(key));
	}
	
	public String getKey(int key) {
		return "Chien-"+key;
	}
}
