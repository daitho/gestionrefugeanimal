package com.mia.itmf.projet.gestionrefugeanimal.exception;

@SuppressWarnings("serial")
public class ExceptionEmploye extends Exception {
	public ExceptionEmploye() {
		super();
	}
	
	public ExceptionEmploye(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionEmploye(String message) {
		super(message);
	}
	
	public ExceptionEmploye(Throwable cause) {
		super(cause);
	}

}
