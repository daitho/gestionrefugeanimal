package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Lapin extends Animal {
	private static int COUNT = 1;
	private final String key;

	public Lapin() {
		super();
		this.key = "Lapin-"+ COUNT++;
	}

	public Lapin(String nom, IRace race, int age, Sexe sexe) {
		super(nom, race, age, sexe);
		this.key = "Lapin-"+ COUNT++;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public RaceLapin getRace() {
		return (RaceLapin) super.getRace();
	}

	public void setRace(RaceLapin race) {
		this.setRace(race);
	}
	
	public enum RaceLapin implements IRace{
		Alaska, Grand_Chinchilla, Neo_Zelandais, Normand, Lynx, Perlfeh, Separator, Papillon_rhénan, Havane_français,
		//ALASKA, GRAND_CHINCHILLA, NEO_ZELANDAIS, NORMAND, LYNX, PERLFEH, SEPARATOR, PAPILLON_RHENAN, HAVANE_FRANCAIS;
	}

}
