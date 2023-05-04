package com.mia.itmf.projet.gestionrefugeanimal.model;

public abstract class Animal {
	private String nom;
	private final IRace race;
	private Integer age;
	private final Sexe sexe;
	//private final Espece espece;
	private StatusAnimal status;
	private Refuge refuge;

	public Refuge getRefuge() {
		return refuge;
	}

	public void setRefuge(Refuge refuge) {
		this.refuge = refuge;
	}

	public Animal() {
		this.race = null;
		this.sexe = null;
		//this.espece =  null;
	}

	public Animal(String nom, IRace race, Integer age, Sexe sexe) {
		this.nom = nom;
		this.race = race;
		this.age = age;
		this.sexe = sexe;
		//this.espece = espece;
		this.status = StatusAnimal.DISPONIBLE;
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


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Sexe getSexe() {
		return sexe;
	}


	public StatusAnimal getStatus() {
		return status;
	}

	public void setStatus(StatusAnimal status) {
		this.status = status;
	}


	public enum Espece{
		CHIEN, CHAT, LAPIN;
	}
	
	public enum Sexe{
		MAXULIN, FEMININ;
	}
	
	public enum StatusAnimal{
		DISPONIBLE, ADOPTER;
	}
	
	
	public  interface IRace{}

	@Override
	public String toString() {
		return "Animal [id=" + getKey() +", Nom refuge = "+getRefuge().getNom()+ ", nom Animal=" + getNom() +  ", race=" + getRace() 
		+ ", age=" + getAge()+"mois"+ ", sexe=" + getSexe() + ", status=" + getStatus() + "]";
	}
	
	

}
