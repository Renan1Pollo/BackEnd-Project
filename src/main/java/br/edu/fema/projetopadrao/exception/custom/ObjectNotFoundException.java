package br.edu.fema.projetopadrao.exception.custom;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public ObjectNotFoundException(String message) {
		super(message);
	}
}
