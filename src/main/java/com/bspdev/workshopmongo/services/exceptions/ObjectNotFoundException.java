package com.bspdev.workshopmongo.services.exceptions;

//Classe responsável por enviar o erro personalizado pra a classe RuntimeException.
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg); //Lança para a a superclasse RuntimeException
	}
}
