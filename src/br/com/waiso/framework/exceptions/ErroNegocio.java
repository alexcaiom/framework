package br.com.waiso.framework.exceptions;

public class ErroNegocio extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	
	public ErroNegocio(String message) {
		super(message);
	}

	public ErroNegocio(String message, Throwable cause) {
		super(message, cause);
		
	}
}