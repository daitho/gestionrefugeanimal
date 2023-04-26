package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;

public class GestionLapin extends GestionAnimal {
	
	public boolean verifierLapin(Lapin chat) {
		return super.verifierAnimal(chat);
	}
	
	public boolean ajouterLapin(Lapin chat) {
		if(super.ajouterAnimal(chat)) {
			return true;
		}
		return false;
	}
	
	public boolean suprimerLapin(Lapin chat) throws Exception {
		if(super.supprimerAnimal(chat)) {
			return true;
		}
		return false;
	}
	
	public boolean miseAJourLapin(Lapin chat) throws Exception {
		return super.miseAJourAnimal(chat);
	}
	
	public Lapin retrouverLapin(int key) {
		return (Lapin) super.retrouverAnimal(getKey(key));
	}
	
	public String getKey(int key) {
		return "Lapin-"+key;
	}

}
