package br.com.waiso.framework.abstratas;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.GregorianCalendar;

import br.com.waiso.framework.utils.UtilsData;
import br.com.waiso.framework.abstratas.TipoMetodo;

/**
 * @author Alex
 *
 */
public abstract class Classe {

	public String CLASSE_NOME = getClass().getSimpleName(); 
	
	/**
	 * Metodo Logger especializado
	 */
	protected void log(String textoParaLog) {
		try {
			System.out.println("Log "+ CLASSE_NOME +" em  " + UtilsData.calendarToStringDataCompleta(GregorianCalendar.getInstance()) + " - " + textoParaLog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que verifica se o objeto eh nulo
	 * @param o
	 * @return
	 */
	public static boolean naoExiste(Object o){
		boolean naoExiste = o==null;
		if (o instanceof String) {
			String texto = (String) o;
			naoExiste = texto.equals("null");
		}
		return naoExiste;
	}
	
	/**
	 * Metodo que verifica se o objeto nao eh nulo
	 * @param o
	 * @return
	 */
	public static boolean existe(Object o){
		boolean existe = !naoExiste(o);
		return existe;
	}
	
	/**
	 * Informe a instancia de um objeto, o Tipo de Metodo (get/set) e o atributo do qual deseja o metodo
	 * @param o
	 * @param tipoMetodo
	 * @param atributo
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static Method getMetodo (Class classe, TipoMetodo tipoMetodo, String atributo) throws SecurityException {
		Method metodo = null;
		try {
		if (existe(classe)) {
			Class tipo = classe;
			for (Field campo : tipo.getDeclaredFields()) {
				if (campo.getName().equals(atributo)) {
					String primeiroCaracter = atributo.substring(0, 1).toUpperCase();
					String nomeMetodo = "";
					switch (tipoMetodo) {
					case GET:
						nomeMetodo = "get" + primeiroCaracter + atributo.substring(1);
						return tipo.getMethod(nomeMetodo, null);
					case SET:
						nomeMetodo = "set" + primeiroCaracter + atributo.substring(1);
						return tipo.getMethod(nomeMetodo, campo.getType());
					default:
						nomeMetodo = atributo;
						return tipo.getMethod(nomeMetodo, campo.getType());
					}
				}
			}
			metodo = tipo.getMethod(atributo, null);
		}
		} catch (NoSuchMethodException e) {
			boolean possuiHeranca = existe(classe.getSuperclass()) && (classe.getSuperclass() != Object.class);
			if (possuiHeranca) {
				return getMetodo(classe.getSuperclass(), tipoMetodo, atributo);
			}
		}
		return metodo;
	}
}