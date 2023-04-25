package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Chien extends Animal {
	
	
	public Chien() {
		super();
	}

	public Chien(int id, String nom, IRace race, int age, Sexe sexe, Status status) {
		super(id, nom, race, age, sexe, status);
	}
	
	public String getKey() throws Exception {
		return "Chien-"+getId();
	}

	public RaceChien getRace() {
		return getRace();
	}

	public void setRace(RaceChien race) {
		this.setRace(race);
	}
	
	public enum RaceChien implements IRace{
		Boledogue, Caniche, Carlin, Cairn, Cocker, Colley, Dobermann, DogueAllemand, Eurasier, Mastiff, Pinscher, Pitbull;
	}

}
