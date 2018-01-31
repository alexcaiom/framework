package br.com.waiso.framework.abstratas.utils;

/**
 * @author Alex
 * @since 13/10/2016
 * Enum para definir o tipo de Log a ser usado.
 * Esse Log pode ser via framework (exemplo Log4J)
 * ou apenas um {@link System.out.println}
 */
public enum TipoLog {

	LOG4J,
	SYS_OUT
	
}
