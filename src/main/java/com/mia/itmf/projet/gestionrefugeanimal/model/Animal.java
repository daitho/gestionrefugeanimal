package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Animal {
	private int id;
	private String nom;
	private IRace race;
	private int age;
	private Sexe sexe;
	private Status status;

	public Animal() {
		super();
	}

	public Animal(int id, String nom, IRace race, int age, Sexe sexe, Status status) {
		super();
		this.id = id;
		this.nom = nom;
		this.race = race;
		this.age = age;
		this.sexe = sexe;
		this.status = status;
	}
	
	public String getKey() throws Exception {
		throw new Exception("La methode getKey doit être surcharger");
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


	public IRace getRace() {
		return race;
	}

	public void setRace(IRace race) {
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


	public enum Espece{
		CHIEN, CHAT, LAPIN;
	}
	
	public enum Sexe{
		MAXULIN, FEMININ;
	}
	
	public enum Status{
		DISPONIBLE, ADOPTER;
	}
	
	public interface IRace{}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom +  ", race=" + race + ", age=" + age
				+ ", sexe=" + sexe + ", status=" + status + "]";
	}
	
	

}
