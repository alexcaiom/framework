package br.com.waiso.framework;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class GerenciadorDeInstanciasDeClasse {

	private static Map<String, Class> instancias = new HashMap<String, Class>();
	
	public static void add(String nomeInteiro, Class classe){
		instancias.put(nomeInteiro, classe);
	}
	
	public static boolean tem(String nomeInteiro){
		return instancias.containsKey(nomeInteiro);
	}
	
	public static void remover(String nomeInteiro){
		instancias.remove(nomeInteiro);
	}
	
	public static Object getClasse(String nomeInteiro) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class classe = null;
		Object objeto = null;
		if (!tem(nomeInteiro)) {
			classe = Class.forName(nomeInteiro);
			objeto = classe.newInstance();
		}
		return objeto;
	}
	
}
