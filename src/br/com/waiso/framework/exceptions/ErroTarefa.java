package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroTarefa extends ErroUsuario {

	private static final long serialVersionUID = 1L;

	public ErroTarefa(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroTarefa(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
}