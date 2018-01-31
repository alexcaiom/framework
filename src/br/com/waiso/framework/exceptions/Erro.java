package br.com.waiso.framework.exceptions;

public class Erro extends ErroUsuario {

	public Erro(String message) {
		super(message);
	}
	
	public Erro(String message, Throwable e) {
		super(message, e);
	}

}
