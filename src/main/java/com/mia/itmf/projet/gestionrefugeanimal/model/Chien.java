package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Chien extends Animal {
	private static int COUNT = 1;
	private final String key;
	
	
	public Chien() {
		super();
		this.key = "Chien-"+ COUNT++;
	}

	public Chien(String nom, IRace race, Integer age, Sexe sexe) {
		super(nom, race, age, sexe);
		this.key = "Chien-"+ COUNT++;
	}
	
	public String getKey(){
		return this.key;
	}

	public RaceChien getRace() {
		return (RaceChien) super.getRace();
	}

	public void setRace(RaceChien race) {
		this.setRace(race);
	}
	
	public enum RaceChien implements IRace{
		Boledogue, Caniche, Carlin, Cairn, Cocker, Colley, Dobermann, DogueAllemand, Eurasier, Mastiff, Pinscher, Pitbull;
		//BOLEDOGUE, CANICHE, CARLIN, CAIRN, COCKER, COLLEY, DOBERMANN, DOGUEALLEMEND, EURASIER, MASTIFF, PINSCHER, PIBULL;
	}

}
