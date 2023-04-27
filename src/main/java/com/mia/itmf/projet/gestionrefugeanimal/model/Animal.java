package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Animal {
	private String nom;
	private final IRace race;
	private int age;
	private final Sexe sexe;
	private Status status;

	public Animal() {
		this.race = null;
		this.sexe = null;
	}

	public Animal(String nom, IRace race, int age, Sexe sexe) {
		this.nom = nom;
		this.race = race;
		this.age = age;
		this.sexe = sexe;
		this.status = Status.DISPONIBLE;
	}
	
	public abstract String getKey();
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public IRace getRace() {
		return race;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sexe getSexe() {
		return sexe;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public enum Espece{
		CHIEN, CHAT, LAPIN;
	}
	
	public enum Sexe{
		MAXULIN, FEMININ;
	}
	
	public enum Status{
		DISPONIBLE, ADOPTER;
	}
	
	public  interface IRace{}

	@Override
	public String toString() {
		return "Animal [id=" + getKey() + ", nom=" + getNom() +  ", race=" + getRace() 
		+ ", age=" + getAge()+"mois"+ ", sexe=" + getSexe() + ", status=" + getStatus() + "]";
	}
	
	

}
