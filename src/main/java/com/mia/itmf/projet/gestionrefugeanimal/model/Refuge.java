package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.mia.itmf.projet.gestionrefugeanimal.model.Adoption.Status;

public class Refuge {
	private int id;
	private String localisation;
	private int nombreAnimal;
	private List<Adoption> listeAdoption;
	
	public Refuge() {
		super();
	}

	public Refuge(int id, String localisation, int nombreAnimal) {
		super();
		this.id = id;
		this.localisation = localisation;
		this.nombreAnimal = nombreAnimal;
	}
	
	public List<Adoption> getListeAdoption(){
		if (listeAdoption == null) {
			listeAdoption = new ArrayList<Adoption>();
		}
		return Collections.unmodifiableList(listeAdoption);
	}
	
	public boolean demanderAdoption(Adoptant adoptant, Animal animal) throws Exception {
		Adoption adoption = new Adoption();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		adoption.setDate(format.format(date));
		adoption.getStatus();
		adoption.setStatus(Status.attente);
		adoption.setAdoptant(adoptant);
		adoption.setAnimal(animal);
		
		if(adoptant == null || animal == null) {
			throw new Exception("Mauvaise information");
		}
		return this.listeAdoption.add(adoption);
	}
	
	public boolean accepterDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.contains(adoption)){
			listeAdoption.get(id).setStatus(Status.accepté);
			return true;
		}
		return false;
	}
	
	public boolean refuserDemandeAdoption(int id) {
		Adoption adoption = retrouverAdoption(id);
		if(listeAdoption.contains(adoption)){
			listeAdoption.get(id).setStatus(Status.rejeté);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
