package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.log.GerenciadorLog;

public class ErroUsuario extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor com a entrada da excecao
	 * 
	 * @param cause
	 */
	public ErroUsuario(Throwable cause) {
		this(null, cause);
		// GerenciadorLog.error(cause);
	}

	public ErroUsuario(String message) {
		super(message);
	}

	/**
	 * Construtor da excecao que recebe como parametro uma mensagem descritiva
	 * sobre a natureza do erro que reflete, assim como a excecao original se
	 * houvesse.
	 * 
	 * @param message texto descritivo da excecao.
	 * @param cause excecao original a ser estabelecida como causa.
	 */
	public ErroUsuario(String message, Throwable cause) {
		super(message, cause);
		if(GerenciadorLog.isDebug(ErroUsuario.class)){
			GerenciadorLog.debug(ErroUsuario.class, cause, message);
		}
	}
	
	/**
	 * Utilizando esse construtor o log sera acionados
	 * @param srcClass
	 * @param message
	 * @param cause
	 */
	public ErroUsuario(Class<?> srcClass, String message, Throwable cause) {
		super(message);
	}
}
