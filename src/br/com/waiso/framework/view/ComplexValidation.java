package br.com.waiso.framework.view;

import br.com.waiso.framework.exceptions.ErroLinkUsuario;

/**
 * Interface usada para validar os dados da tela, esta interface pode ser usada
 * como closure ou ter uma implementacao caso seja necessario validacao com dependencia
 * de campos. A ideia eh usar apenas UserLinkException para subir as excecoes.
 */
public interface ComplexValidation {

	/**
	 * Metodo responsavel pela validacao do campo
	 * @param name Nome do campo para ser incluido no UserLinkException
	 * @param value Valor do campo digitado pelo usuario
	 * @throws ErroLinkUsuario Caso a validacao nao seja satisfeita
	 */
	public void validate(String name, String value) throws ErroLinkUsuario;
}