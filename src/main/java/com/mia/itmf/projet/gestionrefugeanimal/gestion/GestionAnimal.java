package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import java.util.HashMap;
import java.util.Map;

import com.mia.itmf.projet.gestionrefugeanimal.model.Animal;

public class GestionAnimal {
	private Map<String, Animal> mapAnimal = new HashMap<String, Animal>();
	
	protected boolean ajouterAnimal(Animal animal) {
		if(!verifierAnimal(animal)) {
			try {
				mapAnimal.put(animal.getKey(), animal);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	protected boolean supprimerAnimal(Animal animal) throws Exception {
		if(verifierAnimal(animal)) {
			mapAnimal.remove(animal.getKey(), animal);
			return true;
		}
		return false;
	}
	
	protected boolean miseAJourAnimal(Animal animal) throws Exception {
		if(verifierAnimal(animal)) {
			mapAnimal.replace(animal.getKey(), animal);
			return true;
		}
		return false;
	}
	
	protected boolean verifierAnimal(Animal animal) {
		try {
			return animal != null && verifierAnimal(animal.getKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected boolean verifierAnimal(String key) {
		return mapAnimal.containsKey(key);
	}
	
	protected Animal retrouverAnimal(String key) {
		if(verifierAnimal(key)) {
			return mapAnimal.get(key);
		}
		return null;
	}

}
