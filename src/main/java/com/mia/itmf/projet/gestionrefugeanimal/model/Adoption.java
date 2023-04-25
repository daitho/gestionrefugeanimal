package com.mia.itmf.projet.gestionrefugeanimal.model;

import java.util.ArrayList;
import java.util.List;

public class Adoption {
	private int id;
	private Status status;
	private String date;
	private Personne personne;
	private List<Animal> listAnimal;
	
	
	public Adoption() {
		super();
	}
	
	public Adoption(int id, String date, Personne personne) {
		super();
		this.id = id;
		this.date = date;
		this.personne = personne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status isStatus() {
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public List<Animal> getListAnimal() {
		if(listAnimal == null) {
			listAnimal = new ArrayList<Animal>();
		}
		return listAnimal;
	}

	public enum Status{
		attente, accepté, rejeté;
	}

	@Override
	public String toString() {
		return "Adoption [id=" + getId() + ", status=" + status + ", date=" + date + ", personne=" + personne.getNom() + "]";
	}
	
	
}
