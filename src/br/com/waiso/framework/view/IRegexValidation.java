package br.com.waiso.framework.view;

public interface IRegexValidation {
	public String expression();
	
	public boolean evaluate(String value);
	
	public String name();
	
}
