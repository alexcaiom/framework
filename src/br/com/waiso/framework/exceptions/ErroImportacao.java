package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroImportacao extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	
	public ErroImportacao(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroImportacao(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
	
	public ErroImportacao(String message) {
		super(message);
	}
}