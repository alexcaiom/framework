package br.com.waiso.framework.exceptions;

import br.com.waiso.framework.view.InputHolder;

public class ErroLinkUsuario extends ErroUsuario{
	
	private static final long serialVersionUID = 1L;
	private String campo;
	
	public ErroLinkUsuario(String campo, String message) {
		super(message);
		this.campo = campo;
	}

	public ErroLinkUsuario(String campo, String message, Throwable cause) {
		super(message, cause);
		this.campo = campo;
	}

	public ErroLinkUsuario(String campo, Throwable cause) {
		super(cause);
		this.campo = campo;
	}
	
	/**
	 * Utilize esse metodo para instanciar a excecao e ja coloca-la no InputHolder Thread Local
	 * para que seja apresentado para o usuario 
	 * @param campo O campo da tela que gerou a excecao
	 * @param message A mensagem da excecao
	 * @return Instancia de UserLinkException
	 */
	public static ErroLinkUsuario newInstanceWithInputHolderHandled(String campo, String message){
		campo = campo == null?"":campo;
		ErroLinkUsuario e = new ErroLinkUsuario(campo, message);
		InputHolder.get().add(e);
		return e;
	}
	
	public String getCampo(){
		return campo;
	}
}