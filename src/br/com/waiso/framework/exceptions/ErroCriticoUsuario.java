package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.i18n.GerenciadorMensagem;
import br.com.waiso.framework.log.GerenciadorLog;

public class ErroCriticoUsuario extends ErroUsuario {

	private static final long serialVersionUID = -8280945186537174047L;

	public ErroCriticoUsuario(Class<?> origin, String messageSystem) {
		super(GerenciadorMensagem.ERROR_GERAL);
		GerenciadorLog.critical(origin, messageSystem);
	}

	public ErroCriticoUsuario(Class<?> origin, String messageSystem, Throwable error){
		super(GerenciadorMensagem.ERROR_GERAL, error);
		GerenciadorLog.critical(origin, error, messageSystem);
	}
	
	public ErroCriticoUsuario(Class<?> origin, String messageSystem, String messageUser, Throwable error){
		super(messageUser, error);
		GerenciadorLog.critical(origin, error, messageSystem);
	}
}