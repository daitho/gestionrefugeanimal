package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Lapin extends Animal {

	public Lapin() {
		super();
	}

	public Lapin(int id, String nom, IRace race, int age, Sexe sexe, Status status) {
		super(id, nom, race, age, sexe, status);
	}
	
	public String getKey() throws Exception {
		return "Lapin-"+getId();
	}
	
	public RaceLapin getRace() {
		return getRace();
	}

	public void setRace(RaceLapin race) {
		this.setRace(race);
	}
	
	public enum RaceLapin implements IRace{
		Alaska, Grand_Chinchilla, Néo_Zélandais, Normand, Lynx, Perlfeh, Separator, Papillon_rhénan, Havane_français;
	}

}
