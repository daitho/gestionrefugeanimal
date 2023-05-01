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
	private final Map<Integer, Adoption> listeAdoption = new HashMap<Integer, Adoption>();
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
	
	//Gestion de la partie adoption-------------------------------------------------------------------------
	public Adoption demanderAdoption(Adoptant adoptant, Animal animal) throws Exception {
		
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
		return this.listeAdoption.put(adoption.getId(), adoption);
	}
	
	public boolean accepterDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(adoption == null) {
			return false;
		}
		adoption.setStatus(Status.ACCEPTE);
		listeAdoption.replace(adoption.getId(), adoption);
		return true;
	}
	
	public boolean refuserDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(adoption == null) {
			return false;
		}
		adoption.setStatus(Status.REJETE);
		listeAdoption.replace(adoption.getId(), adoption);
		return true;
	}
	
	public boolean supprimerDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.containsKey(id)){
			
			return listeAdoption.remove(id, adoption);
		}
		return false;
	} 
	
	public Adoption retrouverAdoption(int idAdoption) {
		if(listeAdoption.containsKey(idAdoption)) {
			return listeAdoption.get(idAdoption);
		}
		return null;
	}
	
	public List<Adoption> retrouverAdoptionParAdoptant(String nomAdoptant){
		List<Adoption> listeAdoptant = new ArrayList<Adoption>();
		for(Map.Entry<Integer, Adoption> keyValue : listeAdoption.entrySet()) {
			if(keyValue.getValue().getAdoptant().getNom().contains(nomAdoptant)) {
				listeAdoptant.add(keyValue.getValue());
			}
		}
		return listeAdoptant;
	}
	
	//Partie animal-----------------------------------------------------------------------------------
	protected boolean ajouterAnimal(Animal animal) {
		if(!verifierAnimal(animal)) {
			try {
				mapAnimal.put(animal.getKey(), animal);
				setNombreAnimal(getNombreAnimal()+1);//incrémentation du nombre d'animal
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
			setNombreAnimal(getNombreAnimal()-1);
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
	
	//Partie personne--------------------------------------------------------------------
	private boolean verifierPersonne(Personne personne) {
		try {
			return personne != null && verifierPersonne(personne.getKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean verifierPersonne(String key) {
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
	
	protected int getNombrePersonne(String nomClass) {
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
	
	//Gestion employe---------------------------------------------------------------------------
	public boolean ajouterEmploye(Employe employe) {
		if(ajouterPersonne(employe)) {
			System.out.println("Employe ajouter ! ");
			return true;
			
		}
		return false;
	}
	
	public boolean supprimerEmploye(Employe employe) throws Exception {
		if(verifierPersonne(employe)) {
			return mapPersonne.remove(employe.getKey(), employe);
		}
		return false;
	}
	
	public boolean miseAJourEmploye(Employe employe) throws Exception {
		if(verifierPersonne(employe)) {
			mapPersonne.replace(employe.getKey(), employe);
			return true;
		}
		return false;
	}
	
	public Employe retrouverEmploye(int key) {
		return (Employe) retrouverPersonne(getKeyEmploye(key));
	}
	
	private String getKeyEmploye(int key) {
		return "Employe-"+key;
	}
	
	//Gestion adoptant---------------------------------------------------------------------------
	public boolean ajouterAdoptant(Adoptant adoptant) {
		if(ajouterPersonne(adoptant)) {
			System.out.println("Adoptant ajouter ! ");
			return true;
			
		}
		return false;
	}
	
	public boolean supprimerAdoptant(Adoptant adoptant) throws Exception {
		if(verifierPersonne(adoptant)) {
			return mapPersonne.remove(adoptant.getKey(), adoptant);
		}
		return false;
	}
	
	public boolean miseAJourAdoptant(Adoptant adoptant) throws Exception {
		if(verifierPersonne(adoptant)) {
			mapPersonne.replace(adoptant.getKey(), adoptant);
			return true;
		}
		return false;
	}
	
	public Adoptant retrouverAdoptant(int key) {
		return (Adoptant) retrouverPersonne(getKeyAdoptant(key));
	}
	
	private String getKeyAdoptant(int key) {
		return "Adoptant-"+key;
	}
	
	public int getNombreAdoptant() {
		return getNombrePersonne("Adoptant");
	}
	
//	public Employe retrouverEmploye(String key) {
//		Employe result = null;
//		for(Employe employe : listeEmploye()) {
//			if(employe.getKey().equals(key)) {
//				result = employe;
//				break;
//			}
//		}
//		return result;
//	}
//	
//	private List<Employe> listeEmploye(){
//		List<Employe> liste = new ArrayList<Employe>();
//		for(Personne personne : mapPersonne.values()) {
//			if(personne instanceof Employe) {
//				liste.add((Employe) personne);
//			}
//		}
//		return liste;
//	}
//	public Adoptant retrouverAdoptant(String key) {
//		Adoptant result = null;
//		for(Adoptant adoptant : listeAdoptant()) {
//			if(adoptant.getKey().equals(key)) {
//				result = adoptant;
//				break;
//			}
//		}
//		return result;
//	}
//	
//	private List<Adoptant> listeAdoptant(){
//		List<Adoptant> liste = new ArrayList<Adoptant>();
//		for(Personne personne : mapPersonne.values()) {
//			if(personne instanceof Adoptant) {
//				liste.add((Adoptant) personne);
//			}
//		}
//		return liste;
//	}

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
		return nombreAnimal;
	}

	public void setNombreAnimal(int nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	//gestion chat-----------------------------------------------------------------------------------
	public boolean verifierChat(Chat chat) {
		return verifierAnimal(chat);
	}
	
	public boolean ajouterChat(Chat chat) {
		if(ajouterAnimal(chat)) {
			System.out.println("Chat ajouté ! ");
			return true;
		}
		return false;
	}
	
	public boolean supprimerChat(Chat chat) throws Exception {
		if(supprimerAnimal(chat)) {
			System.out.println("Chat supprimé ! ");
			return true;
		}
		return false;
	}
	
	public boolean miseAJourChat(Chat chat) throws Exception {
		return miseAJourAnimal(chat);
	}
	
	public Chat retrouverChat(int key) {
		return (Chat) retrouverAnimal(getKeyChat(key));
	}
	
	public String getKeyChat(int key) {
		return "Chat-"+key;
	}
	
	public int getNombreChat() {
		return getNombreAnimal("Chat");
	}
	
	public void afficherListeChat() {
		afficherListeAnimal("Chat");
	}
	
	//Gestion chien--------------------------------------------------------------------------------------------
	public boolean verifierChien(Chien chien) {
		return verifierAnimal(chien);
	}
	
	public boolean ajouterChien(Chien chien) {
		if(ajouterAnimal(chien)) {
			System.out.println("Chien ajouté !");
			return true;
		}
		return false;
	}
	
	public boolean supprimerChien(Chien chien){
		if(supprimerAnimal(chien)) {
			System.out.println("Chien supprimé !");
			return true;
		}
		return false;
	}
	
	public boolean miseAJourChien(Chien chien) throws Exception {
		return miseAJourAnimal(chien);
	}
	
	public Chien retrouverChien(int key) {
		return (Chien) retrouverAnimal(getKeyChien(key));
	}
	
	public String getKeyChien(int key) {
		return "Chien-"+key;
	}
	
	public int getNombreChien() {
		return getNombreAnimal("Chien");
	}
	
	public void afficherListeChien() {
		afficherListeAnimal("Chien");
	}
	
	//Gestion lapin----------------------------------------------------------------------------
	public boolean verifierLapin(Lapin chat) {
		return verifierAnimal(chat);
	}
	
	public boolean ajouterLapin(Lapin chat) {
		if(ajouterAnimal(chat)) {
			System.out.println("Lapin ajouté ! ");
			return true;
		}
		return false;
	}
	
	public boolean supprimerLapin(Lapin chat) throws Exception {
		if(supprimerAnimal(chat)) {
			System.out.println("Lapin supprimé ! ");
			return true;
		}
		return false;
	}
	
	public boolean miseAJourLapin(Lapin chat) throws Exception {
		return miseAJourAnimal(chat);
	}
	
	public Lapin retrouverLapin(int key) {
		return (Lapin) retrouverAnimal(getKeyLapin(key));
	}
	
	public String getKeyLapin(int key) {
		return "Lapin-"+key;
	}
	
	public int getNombreLapin() {
		return getNombreAnimal("Lapin");
	}
	
	public void afficherListeLapin() {
		afficherListeAnimal("Lapin");
	}
	
	@Override
	public String toString() {
		return "Refuge [id=" + getId() +", nom=" + getNom() + ", localisation=" + getLocalisation() + ", nombreAnimal=" + getNombreAnimal()+ "]";
	}
	
	
	

}
