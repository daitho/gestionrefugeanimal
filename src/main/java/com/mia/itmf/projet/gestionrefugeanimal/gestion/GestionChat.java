package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;

public class GestionChat extends GestionAnimal {
	
	public boolean verifierChat(Chat chat) {
		return super.verifierAnimal(chat);
	}
	
	public boolean ajouterChat(Chat chat) {
		if(super.ajouterAnimal(chat)) {
			return true;
		}
		return false;
	}
	
	public boolean suprimerChat(Chat chat) throws Exception {
		if(super.supprimerAnimal(chat)) {
			return true;
		}
		return false;
	}
	
	public boolean miseAJourChat(Chat chat) throws Exception {
		return super.miseAJourAnimal(chat);
	}
	
	public Chat retrouverChat(int key) {
		return (Chat) super.retrouverAnimal(getKey(key));
	}
	
	public String getKey(int key) {
		return "Chat-"+key;
	}

}
