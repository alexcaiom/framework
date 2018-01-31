package br.com.waiso.framework.utilitario;

import br.com.waiso.framework.exceptions.ErroConversor;

public interface IConverter<T> {

	public T convert(String valor) throws ErroConversor;
	
}
