package br.com.waiso.framework.utilitario;

import br.com.waiso.framework.exceptions.ErroConversor;

public class LongUtils implements IConverter<Long>{

	private static LongUtils instance = new LongUtils();
	
	private LongUtils(){}
	
	public static LongUtils getInstance(){
		return instance;
	}
	
	/**
	 *Converter um objeto String em Long
	 *
	 * @param valor O valor a ser convertido
	 * @return Objeto Long
	 * @throws ErroConversor
	 */
	public Long convert(String valor) throws ErroConversor{
		Long newLong = null;
		if (valor != null && !valor.equals("")){
			try{
				newLong = Long.valueOf(valor);
			}catch(NumberFormatException ne){
				throw new ErroConversor(this.getClass(), ne);
			}
		}
		return newLong;
	}
	
	public boolean isBlank(Long valor){
		return (valor == null || Long.signum(valor) == 0);
	}
	
	  public static long parseLong(String value) {
	        if (!StringUtils.isBlank(value) ) {
	            return Long.parseLong(value.trim());
	        }
	        return 0L;
	    }

	    public static long parseLong(Number value) {
	        if (value != null) {
	            if (value instanceof Long) {
	                return value.longValue();
	            } else if (value instanceof Integer) {
	                long l = (long) value.intValue();
	                return Long.valueOf(l);
	            }
	        }
	        return 0;
	    }
}
