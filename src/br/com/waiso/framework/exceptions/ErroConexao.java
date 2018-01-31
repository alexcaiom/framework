package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroConexao extends ErroUsuario {

	private static final long serialVersionUID = 1L;
	
	public ErroConexao(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroConexao(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
}