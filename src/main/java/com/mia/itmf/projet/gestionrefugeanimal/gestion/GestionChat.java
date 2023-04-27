package com.mia.itmf.projet.gestionrefugeanimal.gestion;

import com.mia.itmf.projet.gestionrefugeanimal.model.Chat;
import com.mia.itmf.projet.gestionrefugeanimal.model.Refuge;

public class GestionChat extends Refuge {
	
	public boolean verifierChat(Chat chat) {
		return super.verifierAnimal(chat);
	}
	
	public boolean ajouterChat(Chat chat) {
		if(super.ajouterAnimal(chat)) {
			System.out.println("Chat ajouté ! ");
			return true;
		}
		return false;
	}
	
	public boolean supprimerChat(Chat chat) throws Exception {
		if(super.supprimerAnimal(chat)) {
			System.out.println("Chat supprimé ! ");
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
	
	public int getNombreChat() {
		return super.getNombreAnimal("Chat");
	}
	
	public void afficherListeChat() {
		super.afficherListeAnimal("Chat");
	}

}
