package br.com.waiso.framework.utilitario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import br.com.waiso.framework.exceptions.ErroConversor;
import br.com.waiso.framework.exceptions.ErroUsuario;
import br.com.waiso.framework.i18n.GerenciadorMensagem;
import br.com.waiso.framework.i18n.LocaleUtils;

/**
 * First attempt to make all the formattings and parsings of currencies uniform.
 *
 * @author Umberto Dissenha Jr
 */
public class FormatCurrency {

	private static Locale locale = LocaleUtils.DEFAULT_LOCALE;
	private static DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
	//public static final String GROUPING_PATTERN = "###,###,###,###,###,##0.00";
	public static final String GROUPING_PATTERN = "#,###,###,###,##0.00##";
	public static final String NO_GROUPING_PATTERN = "0.00";
	public static final String ZERO = formatCurrency(0);

		/**
	 * Instance decimal format using:
	 * <p>
	 * ISO 639 language code to portuguese - pt
	 * ISO 4217 code of the currency to Mozambique
	 *
	 * Formats is not thread-safe, so we must create one for each invocation.
	 * Later on, we can do some object pooling.
	 */
	public static DecimalFormat getFormat(String pattern)
	{
		DecimalFormat df = new DecimalFormat(pattern, dfs);

		df.setParseBigDecimal(true);
		df.setCurrency(Currency.getInstance(LocaleUtils.DEFAULT_CURRENCY));

		return df;
	}

	/**
	 * Gets our default format.
	 *
	 * @return a decimal format for the pattern
	 * <i>###,###,###,###,###,##0.00</i>
	 */
	public static DecimalFormat getFormat()
	{
		return getFormat(GROUPING_PATTERN);
	}

	/**
	 * Fomat a BigDecimal value. Example: 100.992,52
	 *
	 * @param value
	 */
	public static String formatCurrency(Number value)
	{
		if (value != null)
			return getFormat().format(value);
		return ZERO;
	}

	/**
	 * Fomat a Integer value. Example: 100.992,52
	 *
	 * @param value
	 */
	public static String formatCurrency(Integer value)
	{
		if (value != null)
			return getFormat().format(value);
		return ZERO;
	}

	public static String formatCurrency(double value)
	{
		return getFormat().format(value);
	}

	/**
	 * Fomat a Long value. Example: 100,00
	 *
	 * @param value
	 */
	public static String formatCurrency(Long value)
	{
		if (value != null)
			return getFormat().format(value);
		return ZERO;
	}

	/**
	 * Fomat a long value. Example: 100,00
	 *
	 * @param value
	 */
	public static String formatCurrency(long value)
	{
		return getFormat().format(value);

	}

	/**
	 * Fomat a float value. Example: 100,00
	 *
	 * @param value
	 */
	public static String formatCurrency(float value)
	{
		return getFormat().format(value);
	}

	public static String formatCurrency(String value) throws ErroUsuario
	{
		if (value != null)
			try
			{
				return getFormat().format(parseCurrency(value));
			}
			catch (Exception e)
			{
				value = value.replace(',', '|');
				value = value.replace('.', ',');
				value = value.replace('|', '.');
				return getFormat().format(parseCurrency(value));
			}
		return ZERO;
	}

	/**
	 * Fomat a BigDecimal value using the given pattern
	 *
	 * @param pattern the pattern to be used.
	 * @param value the value to format
	 */
	public static String formatCurrency(String pattern, BigDecimal value)
	{
		if (value != null)
			return getFormat(pattern).format(value);
		return ZERO;
	}

	/**
	 * Fomat a BigDecimal value with no grouping separator (dots, in our case).
	 * Example: 100992,52
	 *
	 * @param value
	 */
	public static String formatCurrencyNoGrouping(BigDecimal value)
	{
		if (value != null)
			return getFormat(NO_GROUPING_PATTERN).format(value);
		return ZERO;
	}


	/**
	 * Format a float value. Example: 100,00. This method is used by the Velocity engine. 
	 * Don't remove it. Otherwise, the PDF documents will not work as expected.
	 *
	 * @param value
	 */
	public static String formatBigDecimalString(String value)
	{
		return getFormat().format(new BigDecimal(value));
	}

	public static String formatCurrencyWithoutSignal(double value)
	{
		return formatCurrency(new BigDecimal(value).abs());
	}

	public static String formatCurrencyWithoutSignal(BigDecimal value)
	{
		return formatCurrency(value.abs());
	}

	public static BigDecimal parseCurrency(String value) throws ErroUsuario
	{
		return parseCurrency(GROUPING_PATTERN, value);
	}

	public static BigDecimal parseCurrencyNoGrouping(String value)
		throws ErroUsuario
	{
		if (value == null || "".equals(value))
		{
			value = "0.00";
		}
		return new BigDecimal(value);
	}

	public static BigDecimal parseCurrency(String pattern, String value)
		throws ErroUsuario
	{
		if (value == null || "".equals(value))
		{
			value = "0,00";
			//String message = GerenciadorMensagem.getMessage("framework.utils.invalid.format", value, pattern);
			//throw new ConverterException(FormatCurrency.class, message);
		}

		DecimalFormat format = getFormat(pattern);

		if (!isValid(format, value))
		{
			String message = GerenciadorMensagem.getMessage("framework.utils.invalid.format", value, pattern);
			throw new ErroConversor(FormatCurrency.class, message);
		}

		try
		{
			Number parsed = getFormat(pattern).parse(value);
			return (parsed instanceof BigDecimal)
					? (BigDecimal) parsed
					: new BigDecimal(parsed.toString());
		}
		catch (ParseException e)
		{
			throw new ErroConversor(FormatCurrency.class, e);
		}
	}

	/**
	 * Calcula uma express�o regular a partir do <code>pattern</code> passado,
	 * e faz o match do <code>value</code> passado com a experess�o calculada.
	 * O <code>pattern</code> deve ser um pattern v�lido para a cria��o
	 * de um <code>DecimalFormat</code>.
	 *
	 * @param format O pattern a seguir (Do tipo do <code>DecimalFormat</code>).
	 * @param value O Valor a validar.
	 * @return <code>true</code> se � valido (matches a express�o regular),
	 * <code>false</code> caso contr�rio.
	 */
	public static boolean isValid(String pattern, String value)
	{
		return isValid(getFormat(pattern), value);
	}

	/**
	 * Calcula uma expressao regular a partir do <code>format</code> passado,
	 * e faz o match do <code>value</code> passado com a experessao calculada.
	 *
	 * @param format O Format a seguir.
	 * @param value O Valor a validar.
	 * @return <code>true</code> se eh valido (matches a expressao regular),
	 * <code>false</code> caso contrario.
	 */
	public static boolean isValid(DecimalFormat format, String value) {
		String decimalSeparator = String.valueOf(dfs.getDecimalSeparator());
		String groupingSeparator = String.valueOf(dfs.getGroupingSeparator());
		int groupingSize = format.getGroupingSize();
		int maxFractionDigits = format.getMaximumFractionDigits();
		int minFractionDigits = format.getMinimumFractionDigits();
		int maxInteger = format.getMaximumIntegerDigits();
		int minInteger = format.getMinimumIntegerDigits();

		// Com grouping padrao a expressao fica assim:
		//   ^\d{1,3}+(\.\d{3})*\,\d{2}$
		// Sem grouping
		//   ^\d{1,max}+\,\d{2}$

		String grouping = groupingSize > 0 ? "(\\"
				+ groupingSeparator
				+ "\\d{"
				+ groupingSize
				+ "})*" : "";
		String integer = (groupingSize > 0 ? "\\d{"
				+ minInteger
				+ ","
				+ groupingSize
				+ "}" : "\\d{" + minInteger + "," + maxInteger + "}")
				+ (minInteger > 0 ? "+" : "");
		String decimal = minFractionDigits > 0 || maxFractionDigits > 0
				? decimalSeparator
						+ "\\d{"
						+ minFractionDigits
						+ ","
						+ maxFractionDigits
						+ "}"
				: "";

		String regex = "^-*" + integer + grouping + decimal + "$";

		return value.matches(regex);
	}
}