package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mia.itmf.projet.gestionrefugeanimal.model.Adoptant;
import com.mia.itmf.projet.gestionrefugeanimal.model.Adoption;
import com.mia.itmf.projet.gestionrefugeanimal.model.Adoption.Status;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal;
import com.mia.itmf.projet.gestionrefugeanimal.model.Animal.StatusAnimal;

public class GestionAdoption {
	
private final List<Adoption> listeAdoption = new ArrayList<>();


   public List<Adoption> getListeAdoption(){
	   return Collections.unmodifiableList(listeAdoption);
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
		this.listeAdoption.add(adoption);
		return adoption;
	}
	
	public boolean verifierAdoption(Adoption adoption) {
		return adoption != null && listeAdoption.contains(adoption);
	}
	
	public void listeDemande(){
		for(Adoption adoption : listeAdoption) {
			if(adoption.getStatus().equals(Status.ATTENTE)) {
				System.out.println(adoption.toString());
			}
		}
	}
	
	//Acepter et refuser  Adoption
	public boolean accepterDemandeAdoption(Adoption adoption) {
		if(verifierAdoption(adoption)) {
			adoption.setStatus(Status.ACCEPTE);
			adoption.getAnimal().setStatus(StatusAnimal.ADOPTER);
			for (Adoption adoption1 : listeAdoption) {
				if(adoption1.getAnimal().equals(adoption.getAnimal()) && !adoption1.getAdoptant().equals(adoption.getAdoptant())) {
					refuserDemandeAdoption(adoption1);
				}
			}
			return true;
		}
		return false;
		
	}
	
	public boolean refuserDemandeAdoption(Adoption adoption) {
		if(adoption == null) {
			return false;
		}
		adoption.setStatus(Status.REJETE);
		//listeAdoption.replace(adoption.getId(), adoption);
		return true;
	}
	
	public boolean supprimerDemandeAdoption(Adoption adoption) {
		if(verifierAdoption(adoption)){
			adoption.getAnimal().setStatus(StatusAnimal.DISPONIBLE);
			return listeAdoption.remove(adoption);
		}
		return false;
	} 
	
	public List<Adoption> retrouverAdoptionParAnimal(Animal animal) {
		List<Adoption> listes = new ArrayList<>();
		for(Adoption adoption : listeAdoption) {
			if(adoption.getAnimal().equals(animal)) {
				listes.add(adoption);
			}
		}
		return listes;
	}
	
	public Adoption retrouverAdoption(Adoptant adoptant, Animal animal) {
		for(Adoption adoption : listeAdoption) {
			if(adoption.getAnimal().equals(animal) && adoption.getAdoptant().equals(adoptant)) {
				return adoption;
			}
		}
		return null;
	}
	
	public List<Adoption> retrouverAdoptionParAdoptant(String nomAdoptant){
		List<Adoption> listes = new ArrayList<>();
		for(Adoption adoption : listeAdoption) {
			if(adoption.getAdoptant().getNom().contains(nomAdoptant) || adoption.getAdoptant().getPrenom().contains(nomAdoptant)) {
				System.out.println(adoption.toString());
				listes.add(adoption);
			}
		}
		return listes;
	}
	


}
