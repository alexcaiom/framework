package br.com.waiso.framework.utilitario;

import java.util.UUID;

public class UUIDUtils {

	public static String generateUUID(){
		return UUID.randomUUID().getMostSignificantBits() + "";
	}
}