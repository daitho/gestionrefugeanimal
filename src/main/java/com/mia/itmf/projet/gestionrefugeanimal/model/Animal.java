package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Animal {
	private int id;
	private String nom;
	private Race race;
	private int age;
	private Sexe sexe;
	private Status status;

	public Animal() {
		super();
	}

	public Animal(int id, String nom, Race race, int age, Sexe sexe, Status status) {
		super();
		this.id = id;
		this.nom = nom;
		this.race = race;
		this.age = age;
		this.sexe = sexe;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
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

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	enum Race{}
	
	public enum Sexe{
		MAXULIN, FEMININ;
	}
	
	public enum Status{
		DISPONIBLE, ADOPTER;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom +  ", race=" + race + ", age=" + age
				+ ", sexe=" + sexe + ", status=" + status + "]";
	}
	
	

}
