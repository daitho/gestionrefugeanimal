package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mia.itmf.projet.gestionrefugeanimal.model.Adoption.Status;

public class Refuge {
	private static int COUNT = 0;
	private final int id;
	private String nom;
	private String localisation;
	private int nombreAnimal;
	private final List<Adoption> listeAdoption = new ArrayList<Adoption>();
	private Map<String, Animal> mapAnimal = new HashMap<String, Animal>();
	private Map<String, Personne> mapPersonne = new HashMap<String, Personne>();
	
	public Refuge() {
		this.id = COUNT++;
	}

	public Refuge(String nom, String localisation, int nombreAnimal) {
		this.id = COUNT++;
		this.nom = nom;
		this.localisation = localisation;
		this.nombreAnimal = nombreAnimal;
	}
	
	public List<Adoption> getListeAdoption(){
		return Collections.unmodifiableList(listeAdoption);
	}
	
	//Gestion de la partie adoption
	public boolean demanderAdoption(Adoptant adoptant, Animal animal) throws Exception {
		
		if(adoptant == null || animal == null) {
			throw new Exception("Mauvaise information");
		}
		Adoption adoption = new Adoption();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		adoption.setDate(format.format(date));
		adoption.setStatus(Status.ATTENTE);
		adoption.setAdoptant(adoptant);
		adoption.setAnimal(animal);
		return this.listeAdoption.add(adoption);
	}
	
	public boolean accepterDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.contains(adoption)){
			listeAdoption.get(id).setStatus(Status.ACCEPTE);
			
			mapAnimal.replace(localisation, null);
			return true;
		}
		return false;
	}
	
	public boolean refuserDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.contains(adoption)){
			listeAdoption.get(id).setStatus(Status.REJETE);
			return true;
		}
		return false;
	}
	
	public boolean supprimerDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.contains(adoption)){
			return listeAdoption.remove(adoption);
		}
		return false;
	} 
	
	public Adoption retrouverAdoption(int idAdoption) {
		for(Adoption adoption : listeAdoption) {
			if(adoption.getId() == idAdoption) {
				return adoption;
			}
		}
		return null;
	}
	
	public List<Adoption> retrouverAdoptionParAdoptant(String nomAdoptant){
		List<Adoption> listeAdoptant = new ArrayList<Adoption>();
		for(Adoption adoption : listeAdoption) {
			if(adoption.getAdoptant().getNom().contains(nomAdoptant)) {
				listeAdoptant.add(adoption);
			}
		}
		return listeAdoptant;
	}
	
	//Partie animal
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
	
	protected boolean supprimerAnimal(Animal animal){
		if(verifierAnimal(animal)) {
			mapAnimal.remove(animal.getKey());
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
	
	protected int getNombreAnimal(String nomClass) {
		int count = 0;
		for(Map.Entry<String, Animal> keyValue : mapAnimal.entrySet()) {
			if(keyValue.getValue().getClass().getSimpleName().equals(nomClass)) {
				count++;
			}
		}
		return count;
	}
	
	
	protected void afficherListeAnimal(String nomEspece) {
		for(Map.Entry<String, Animal> keyValue : mapAnimal.entrySet()) {
			if(keyValue.getValue().getClass().getSimpleName().equals(nomEspece)) {
				System.out.println(keyValue.getValue().toString());
			}
		}
	}
	
	//Partie personne
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
	
	protected boolean ajouterPersonne(Personne personne) {
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
	
	protected boolean supprimerPersonne(Personne peronne) throws Exception {
		if(verifierPersonne(peronne)) {
			return mapPersonne.remove(peronne.getKey(), peronne);
		}
		return false;
	}
	
	protected boolean miseAJourPersonne(Personne personne) throws Exception {
		if(verifierPersonne(personne)) {
			mapPersonne.replace(personne.getKey(), personne);
			return true;
		}
		return false;
	}
	
	protected Personne retrouverEmploye(String key) {
		Employe result = null;
		for(Employe employe : listeEmploye()) {
			if(employe.getKey().equals(key)) {
				result = employe;
				break;
			}
		}
		return result;
	}
	
	private List<Employe> listeEmploye(){
		List<Employe> liste = new ArrayList<Employe>();
		for(Personne personne : mapPersonne.values()) {
			if(personne instanceof Employe) {
				liste.add((Employe) personne);
			}
		}
		return liste;
	}

	//Getter et setter
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
		return nombreAnimal;
	}

	public void setNombreAnimal(int nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	@Override
	public String toString() {
		return "Refuge [id=" + getId() +", nom=" + getNom() + ", localisation=" + getLocalisation() + ", nombreAnimal=" + getNombreAnimal()+ "]";
	}
	
	
	

}
