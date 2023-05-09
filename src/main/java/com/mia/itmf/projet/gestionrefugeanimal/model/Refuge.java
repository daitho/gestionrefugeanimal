package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mia.itmf.projet.gestionrefugeanimal.exception.ExceptionAnimal;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.IRace;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.Sexe;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.StatusAnimal;
import com.mia.itmf.projet.gestionrefugeanimal.tools.MapTool;

public class Refuge {
	private static int COUNT = 0;
	private final int id;
	private String nom;
	private String localisation;
	private Map<String, Animal> mapAnimal = new LinkedHashMap<String, Animal>();
	private Map<String, Employe> mapEmploye = new TreeMap<String, Employe>();
	
	public Refuge() {
		this.id = COUNT++;
	}

	public Refuge(String nom, String localisation) {
		this.id = COUNT++;
		this.nom = nom;
		this.localisation = localisation;
	}
	
	//Partie animal-----------------------------------------------------------------------------------
	public boolean ajouterAnimal(Animal animal) throws ExceptionAnimal {
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
	
	public boolean supprimerAnimal(String key) throws ExceptionAnimal{
		if(mapAnimal.containsKey(key)) {
			mapAnimal.remove(key);
			return true;
		}
		return false;
	}
	
	public boolean supprimerAnimal(Animal animal) throws ExceptionAnimal{
		if(verifierAnimal(animal)) {
			mapAnimal.remove(animal.getKey());

			return true;
		}
		return false;
	}
	
	public boolean miseAJourAnimal(Animal animal) throws ExceptionAnimal {
		if(verifierAnimal(animal)) {
			animal.setRefuge(this);
			mapAnimal.replace(animal.getKey(), animal);
			return true;
		}
		return false;
	}
	
	public boolean miseAJourAnimal(Animal animal, String nom, Integer age, StatusAnimal status) throws ExceptionAnimal {
		if(verifierAnimal(animal)) {
			if(nom != null) {
				animal.setNom(nom);
			}
			if(age != null && age >= 0) {
				animal.setAge(age);
			}
			if(status != null){
				animal.setStatus(status);
			}
			return true;
		}
		return false;
	}
	
	protected boolean verifierAnimal(Animal animal) throws ExceptionAnimal{
		if(animal == null) {
			throw new ExceptionAnimal("L'animal est null");
		}
		
		for (Animal resultAnimal : mapAnimal.values()) {
			if(resultAnimal.getAge() == animal.getAge() && resultAnimal.getNom().equals(animal.getNom()) && resultAnimal.getSexe().equals(animal.getSexe()) && resultAnimal.getStatus().equals(animal.getStatus())) {
				return true;
			}
		}
		
		return false;
	}
	
//	protected boolean verifierAnimal(String key) {
//		return mapAnimal.containsKey(key);
//	}
//	
//	public Animal retrouverAnimal(String key) {
//		if(verifierAnimal(key)) {
//			return mapAnimal.get(key);
//		}
//		return null;
//	}
	
	public Animal retrouverUnAnimal(String nom, IRace race, Integer age, Sexe sexe) throws ExceptionAnimal {
		return MapTool.getMapElement(mapAnimal, Animal.class, false, addElementListAnimaux(nom, race, age, sexe));
	}
	
	public List<Animal> retrouverAnimaux(String nom, IRace race, Integer age, Sexe sexe) throws ExceptionAnimal {
		return MapTool.getMapElements(mapAnimal, true, addElementListAnimaux(nom, race, age, sexe));
	}
	
	private List<MapTool.SearchCriteria<Animal>> addElementListAnimaux(String nom, IRace race, Integer age, Sexe sexe) throws ExceptionAnimal{
		if(nom==null && age==null && sexe==null && race == null) {
			throw new ExceptionAnimal("La recherche dois contenir au moins une valeur");
		}
		List<MapTool.SearchCriteria<Animal>> criteriaList = new ArrayList<>();
		if(nom != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Animal::getNom, nom));
		}else if(sexe != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Animal::getSexe, sexe));
		}else if(age != null && age >= 0) {
			criteriaList.add(new MapTool.SearchCriteria<>(Animal::getAge, age));
		}else if(race != null){
			criteriaList.add(new MapTool.SearchCriteria<>(Animal::getRace, race));
		}
		
		return criteriaList;
	}
	
	public void afficherListeAnimaux() {
		for(Animal animal : mapAnimal.values()) {
			System.out.println(animal.toString());
		}
	}
	
	
	public void afficherListeAnimauxParEspece(String nomEspece) {
		System.out.println(nomEspece);
		for(Map.Entry<String, Animal> keyValue : mapAnimal.entrySet()) {
			if(keyValue.getValue().getClass().getSimpleName().toUpperCase().contains(nomEspece.toUpperCase())) {
				System.out.println(keyValue.getValue().toString());
			}
		}
	}
	
	//Partie employe--------------------------------------------------------------------
	protected boolean verifierEmploye(Employe employe) {
		try {
			return employe != null && verifierEmploye(employe.getKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected boolean verifierEmploye(String key) {
		return mapEmploye.containsKey(key);
	}
	
	public boolean ajouterEmploye(Employe employe) {
		if(!verifierEmploye(employe)) {
			try {
				mapEmploye.put(employe.getKey(), employe);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean supprimerEmploye(Employe employe) throws Exception {
		if(verifierEmploye(employe)) {
			return mapEmploye.remove(employe.getKey(), employe);
		}
		return false;
	}
	
	public boolean miseAJourEmploye(Employe employe) throws Exception {
		if(verifierEmploye(employe)) {
			mapEmploye.replace(employe.getKey(), employe);
			return true;
		}
		return false;
	}
	
	public int getNombreEmploye() {
		return mapEmploye.size();
	}
	
	public void consulterListeEmployes() {
		for(Employe employe : mapEmploye.values()) {
			System.out.println(employe.toString());
		}
	}
	
	public Employe retrouverUnEmploye(String nom, String prenom, String email) {

		return (Employe) retrouverEmploye(nom, prenom, email, false);
	}
	
	public List<Employe> retrouverEmploye(String nom,String prenom, String email, boolean unique) {
        List<MapTool.SearchCriteria<Employe>> criteriaList = new ArrayList<>();
		
		criteriaList.add(new MapTool.SearchCriteria<>(Employe::getNom, nom));
		criteriaList.add(new MapTool.SearchCriteria<>(Employe::getPrenom, prenom));
		criteriaList.add(new MapTool.SearchCriteria<>(Employe::getEmail, email));
		
		List<Employe> result = MapTool.getMapElements(mapEmploye, unique, criteriaList);

		return result;
	}
	
//	public Personne retrouverPersonne(String... criteres) {
//		Generique generique = new Generique();
////		if(verifierPersonne(key)) {
////			return mapPersonne.get(key);
////		}
//		return (Personne) generique.rechercher(mapPersonne, false, criteres);
//	}
//	
//	public List<Personne> retrouverPersonne(boolean unique, String... criteres) {
//		Generique generique = new Generique();
////		if(verifierPersonne(key)) {
////			return mapPersonne.get(key);
////		}
//		return generique.rechercher(mapPersonne, unique, criteres);
//	}
//	
//	public Adoptant retrouverAdoptant(String key) {
//		
//	    return (Adoptant) retrouverPersonne(key);
//    }

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
