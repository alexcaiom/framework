package br.com.waiso.framework.utilitario;

import br.com.waiso.framework.exceptions.ErroConversor;

public class StringConverter implements IConverter<String> {

	private static StringConverter instance = new StringConverter();

	private StringConverter() {
	}

	public static StringConverter getInstance() {
		return instance;
	}

	public String convert(String valor) throws ErroConversor {
		return valor;
	}
}
