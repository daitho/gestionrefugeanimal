package com.mia.itmf.projet.gestionrefugeanimal.model;

public class Adoption {
	private int id;
	private Status status;
	private String date;
	private Adoptant adoptant;
	private Animal animal;
	
	
	public Adoption() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		attente, accepté, rejeté;
	}

	@Override
	public String toString() {
		return "Adoption [id=" + getId() + ", status=" + status + ", date=" + date + ", Nom =" + adoptant.getNom() + "]";
	}
	
	
}
