package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroRespostaWS extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	
	public ErroRespostaWS(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroRespostaWS(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
}