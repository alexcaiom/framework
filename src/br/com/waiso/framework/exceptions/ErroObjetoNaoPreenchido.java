package br.com.waiso.framework.exceptions;

public class ErroObjetoNaoPreenchido extends NullPointerException {

	public ErroObjetoNaoPreenchido() {
		super("O objeto não foi preenchido");
	}
	
	public ErroObjetoNaoPreenchido(Object o) {
		super("O objeto "+o+" não foi preenchido");
	}
	
}
