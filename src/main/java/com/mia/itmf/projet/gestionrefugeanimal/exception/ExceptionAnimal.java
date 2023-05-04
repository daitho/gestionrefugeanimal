package com.mia.itmf.projet.gestionrefugeanimal.exception;

@SuppressWarnings("serial")
public class ExceptionAnimal extends Exception {
	
	public ExceptionAnimal() {
		super();
	}
	
	public ExceptionAnimal(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionAnimal(String message) {
		super(message);
	}
	
	public ExceptionAnimal(Throwable cause) {
		super(cause);
	}

}
