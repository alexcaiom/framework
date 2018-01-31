package br.com.waiso.framework.view;

import java.util.List;

import br.com.waiso.framework.exceptions.ErroUsuario;

/**
 * Classe thread-local responsavel por guardar uma lista de UserException
 * Uma atencao especial nesta implementacao eh que a lista a ser usada pela aplicacao
 * deve ser inicializada pela classe cliente, senao um NullPointerException pode ocorrer
 * no momento de utilizar a lista.
 * 
 * @author rodolfodias
 *
 */
public class InputHolder {
	static InheritableThreadLocal<List<ErroUsuario>> threadLocal = new InheritableThreadLocal<List<ErroUsuario>>();

	public static void set(List<ErroUsuario> list) {
		threadLocal.set(list);
	}

	public static List<ErroUsuario> get() {
		return threadLocal.get();
	}

	public static void clear() {
		get().clear();
		threadLocal.remove();
	}
}