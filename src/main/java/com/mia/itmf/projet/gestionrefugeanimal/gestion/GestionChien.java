package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Chien;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

public class GestionChien extends Refuge {
	
	public boolean verifierChien(Chien chien) {
		return super.verifierAnimal(chien);
	}
	
	public boolean ajouterChien(Chien chien) {
		if(super.ajouterAnimal(chien)) {
			System.out.println("Chien ajouté ! ");
			return true;
		}
		return false;
	}
	
	public boolean supprimerChien(Chien chien){
		if(super.supprimerAnimal(chien)) {
			System.out.println("Chien supprimé ! ");
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
	
	public int getNombreChien() {
		return super.getNombreAnimal("Chien");
	}
	
	public void afficherListeChien() {
		super.afficherListeAnimal("Chien");
	}
}
