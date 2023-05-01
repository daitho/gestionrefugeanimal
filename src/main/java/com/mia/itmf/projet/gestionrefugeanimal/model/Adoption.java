package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Adoption {
	private final int id;
	private Status status;
	private String date;
	private Adoptant adoptant;
	private Animal animal;
	private static int COUNT = 1;
	
	
	public Adoption() {
		this.id = COUNT++;
	}
	
	

	public Adoption(Status status, String date, Adoptant adoptant, Animal animal) {
		this.id = COUNT++;
		this.status = status;
		this.date = date;
		this.adoptant = adoptant;
		this.animal = animal;
	}



	public int getId() {
		return this.id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Adoptant getAdoptant() {
		return adoptant;
	}

	public void setAdoptant(Adoptant adoptant) {
		this.adoptant = adoptant;
	}
	
	
	
//	public List<Animal> getListAnimal() {
//		if(listAnimal == null) {
//			listAnimal = new ArrayList<Animal>();
//		}
//		return listAnimal;
//	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public enum Status{
		ATTENTE, ACCEPTE, REJETE;
	}

	@Override
	public String toString() {
		return "Adoption [id= " + getId() + ", status= " + getStatus() + ", date= " + getDate() + ", Nom adoptant= " + getAdoptant().getNom() +", Nom animal= "+getAnimal().getNom()+ "]";
	}
	
	
}
