package com.mia.itmf.projet.gestionrefugeanimal.exception;

@SuppressWarnings("serial")
public class ExceptionAdoption extends Exception {

	public ExceptionAdoption() {
		super();
	}
	
	public ExceptionAdoption(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionAdoption(String message) {
		super(message);
	}
	
	public ExceptionAdoption(Throwable cause) {
		super(cause);
	}
}
