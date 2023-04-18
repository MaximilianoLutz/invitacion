package com.es.mlutzdev.usuario.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String messaje) {
		super(messaje);
	}

}
