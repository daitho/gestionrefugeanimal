package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Lapin;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

public class GestionLapin extends Refuge {
	
	public boolean verifierLapin(Lapin chat) {
		return super.verifierAnimal(chat);
	}
	
	public boolean ajouterLapin(Lapin chat) {
		if(super.ajouterAnimal(chat)) {
			System.out.println("Lapin ajouté ! ");
			return true;
		}
		return false;
	}
	
	public boolean supprimerLapin(Lapin chat) throws Exception {
		if(super.supprimerAnimal(chat)) {
			System.out.println("Lapin supprimé ! ");
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
	
	public int getNombreLapin() {
		return super.getNombreAnimal("Lapin");
	}
	
	public void afficherListeLapin() {
		super.afficherListeAnimal("Lapin");
	}
	
}
