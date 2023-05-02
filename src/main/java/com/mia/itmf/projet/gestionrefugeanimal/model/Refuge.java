package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.util.HashMap;
import java.util.Map;

public class Refuge {
	private static int COUNT = 0;
	private final int id;
	private String nom;
	private String localisation;
	private Map<String, Animal> mapAnimal = new HashMap<String, Animal>();
	private Map<String, Personne> mapPersonne = new HashMap<String, Personne>();
	
	public Refuge() {
		this.id = COUNT++;
	}

	public Refuge(String nom, String localisation) {
		this.id = COUNT++;
		this.nom = nom;
		this.localisation = localisation;
	}
	
	//Partie animal-----------------------------------------------------------------------------------
	public boolean ajouterAnimal(Animal animal) {
		if(!verifierAnimal(animal)) {
			try {
				animal.setRefuge(this);
				mapAnimal.put(animal.getKey(), animal);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean supprimerAnimal(Animal animal){
		if(verifierAnimal(animal)) {
			mapAnimal.remove(animal.getKey());

			return true;
		}
		return false;
	}
	
	public boolean miseAJourAnimal(Animal animal) throws Exception {
		if(verifierAnimal(animal)) {
			animal.setRefuge(this);
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
	
	public Animal retrouverAnimal(String key) {
		if(verifierAnimal(key)) {
			return mapAnimal.get(key);
		}
		return null;
	}
	
	
//	public int getNombreAnimal(String nomEspece) {
//		int count = 0;
//		for(Map.Entry<String, Animal> keyValue : mapAnimal.entrySet()) {
//			if(keyValue.getValue().getClass().getSimpleName().equals(nomEspece)) {
//				count++;
//			}
//		}
//		return count;
//	}
	
	
	public void afficherListeAnimal(String nomEspece) {
		nomEspece = nomEspece.substring(0,1).toUpperCase()+""+nomEspece.substring(1, nomEspece.length()).toLowerCase();
		System.out.println(nomEspece);
		for(Map.Entry<String, Animal> keyValue : mapAnimal.entrySet()) {
			if(keyValue.getValue().getClass().getSimpleName().contains(nomEspece)) {
				System.out.println(keyValue.getValue().toString());
			}
		}
	}
	
	//Partie personne--------------------------------------------------------------------
	protected boolean verifierPersonne(Personne personne) {
		try {
			return personne != null && verifierPersonne(personne.getKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected boolean verifierPersonne(String key) {
		return mapPersonne.containsKey(key);
	}
	
	public boolean ajouterPersonne(Personne personne) {
		if(!verifierPersonne(personne)) {
			try {
				mapPersonne.put(personne.getKey(), personne);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean supprimerPersonne(Personne personne) throws Exception {
		if(verifierPersonne(personne)) {
			return mapPersonne.remove(personne.getKey(), personne);
		}
		return false;
	}
	
	public boolean miseAJourPersonne(Personne personne) throws Exception {
		if(verifierPersonne(personne)) {
			mapPersonne.replace(personne.getKey(), personne);
			return true;
		}
		return false;
	}
	
	public int getNombrePersonne(String nomClass) {
		int count = 0;
		for(Map.Entry<String, Personne> keyValue : mapPersonne.entrySet()) {
			if(keyValue.getValue().getClass().getSimpleName().equals(nomClass)) {
				count++;
			}
		}
		return count;
	}
	
	protected Personne retrouverPersonne(String key) {
		if(verifierPersonne(key)) {
			return mapPersonne.get(key);
		}
		return null;
	}
	
	public Adoptant retrouverAdoptant(String key) {
		
	    return (Adoptant) retrouverPersonne(key);
    }

	//Getter et setter--------------------------------------------------------------------
	public int getId() {
		return this.id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getNombreAnimal() {
		return mapAnimal.size();
	}


	@Override
	public String toString() {
		return "Refuge [id=" + getId() +", nom=" + getNom() + ", localisation=" + getLocalisation() + ", nombreAnimal=" + getNombreAnimal()+ "]";
	}
	
	
//	public Employe retrouverEmploye(String key) {
//	Employe result = null;
//	for(Employe employe : listeEmploye()) {
//		if(employe.getKey().equals(key)) {
//			result = employe;
//			break;
//		}
//	}
//	return result;
//}
//
//private List<Employe> listeEmploye(){
//	List<Employe> liste = new ArrayList<Employe>();
//	for(Personne personne : mapPersonne.values()) {
//		if(personne instanceof Employe) {
//			liste.add((Employe) personne);
//		}
//	}
//	return liste;
//}
//public Adoptant retrouverAdoptant(String key) {
//	Adoptant result = null;
//	for(Adoptant adoptant : listeAdoptant()) {
//		if(adoptant.getKey().equals(key)) {
//			result = adoptant;
//			break;
//		}
//	}
//	return result;
//}
//
//private List<Adoptant> listeAdoptant(){
//	List<Adoptant> liste = new ArrayList<Adoptant>();
//	for(Personne personne : mapPersonne.values()) {
//		if(personne instanceof Adoptant) {
//			liste.add((Adoptant) personne);
//		}
//	}
//	return liste;
//}
	

}
