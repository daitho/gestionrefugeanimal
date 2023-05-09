package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Chat extends Animal {
	private static int COUNT = 1;
	private final String key;

	public Chat() {
		super();
		this.key = "Chat-"+ COUNT++;
	}

	public Chat(String nom, IRace race, Integer age, Sexe sexe) {
		super(nom, race, age, sexe);
		this.key = "Chat-"+ COUNT++;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public RaceChat getRace() {
		return (RaceChat) super.getRace();
	}

	public void setRace(RaceChat race) {
		this.setRace(race);
	}
	
	public enum RaceChat implements IRace{
		Abyssin, Anatoli, Asian, Balinais, Burmese, Burmilla, Chartreux, Chantilly, Chausie, Cymric, Donskoy, Manx, Ragdoll, Sphynx;
	}

}
