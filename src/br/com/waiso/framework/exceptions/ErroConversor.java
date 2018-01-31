package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroConversor extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	
	public ErroConversor(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroConversor(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
}