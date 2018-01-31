package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

@SuppressWarnings("rawtypes")
public class ErroAoEnviarRequisicaoWS extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	
	public ErroAoEnviarRequisicaoWS(Class origin, Throwable cause) {
		super(cause);
		GerenciadorLog.error(origin, cause);
	}
	
	public ErroAoEnviarRequisicaoWS(Class origin, String message) {
		super(message);
		GerenciadorLog.error(origin, message);
	}
}