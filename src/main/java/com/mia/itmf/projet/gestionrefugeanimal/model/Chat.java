package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Chat extends Animal {

	public Chat() {
		super();
	}

	public Chat(int id, String nom, IRace race, int age, Sexe sexe, Status status) {
		super(id, nom, race, age, sexe, status);
	}
	
	public String getKey() throws Exception {
		return "Chat-"+getId();
	}
	
	public RaceChat getRace() {
		return getRace();
	}

	public void setRace(RaceChat race) {
		this.setRace(race);
	}
	
	public enum RaceChat implements IRace{
		Abyssin, Anatoli, Asian, Balinais, Burmese, Burmilla, Chartreux, Chantilly, Chausie, Cymric, Donskoy, Manx, Ragdoll, Sphynx
	}

}
