package br.edu.fema.projetopadrao.utils.conversao.dataHora;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import org.springframework.lang.NonNull;

import br.edu.fema.projetopadrao.utils.conversao.formatacao.FormatacaoUtils;

/**
 * 
 * Classe responsável por manipular a classe de hora
 * {@link LocalTime} utilizando diversas formatações
 * e conversões entre {@link LocalTime} e {@link String}
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.1 - 28/07/2022
 *
 */
public final class LocalTimeUtils {
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * com a hora atual para {@link String} no formato {@code HH:mm:ss}
	 * 
	 * @return {@code String}
	 */
	public static String converterLocalTimeAtualParaString() {
		return converterLocalTimeParaString(LocalTime.now());
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * com a hora atual e os segundos zerados para 
	 * {@link String} no formato {@code HH:mm:ss}
	 * 
	 * @return {@code String}
	 * 
	 * @since 1.1
	 */
	public static String converterLocalTimeAtualComSegundosZeradosParaString() {
		return converterLocalTimeComSegundosZeradosParaString(LocalTime.now());
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * com a hora atual para {@link String} no formato {@code HH:mm}
	 * 
	 * @return {@code String}
	 */
	public static String converterHoraMinutoAtualParaString() {
		return converterHoraMinutoParaString(LocalTime.now());
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * para o formato {@code HH:mm:ss}
	 * 
	 * @param hora - {@link LocalTime}
	 * @return {@code String}
	 */
	public static String converterLocalTimeParaString(LocalTime hora) {
		return converterLocalTimeParaString(hora, FormatacaoUtils.FORMATADOR_HORA);
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * com a hora e os segundos zerados para {@link String} 
	 * no formato {@code HH:mm:ss}
	 * 
	 * @param hora - {@link LocalTime}
	 * @return {@code String}
	 * 
	 * @since 1.1
	 */
	public static String converterLocalTimeComSegundosZeradosParaString(LocalTime hora) {
		return converterLocalTimeParaString(hora, FormatacaoUtils.FORMATADOR_HORA_MINUTO) + ":00";
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * para o formato {@code HH:mm}
	 * 
	 * @param hora - {@link LocalTime}
	 * @return {@code String}
	 */
	public static String converterHoraMinutoParaString(LocalTime hora) {
		return converterLocalTimeParaString(hora, FormatacaoUtils.FORMATADOR_HORA_MINUTO);
	}
	
	/**
	 * Método responsável por converter um {@link LocalTime}
	 * com base no tipo de formatação do {@link DateTimeFormatter}
	 * 
	 * @param hora - {@link LocalTime}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code String}
	 */
	public static String converterLocalTimeParaString(LocalTime hora, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(hora))
			throw new NullPointerException("A hora não pode ser nula!");
		
		try {
			return formatter.format(hora);
		}
		catch (DateTimeParseException e) {
			throw new DateTimeException("DateTimeFormatter inválido!");
		}
	}
	
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de hora no formato {@code HH:mm:ss} para {@link LocalTime}
	 * 
	 * @param hora - {@link String}
	 * @return {@code LocalTime}
	 */
	public static LocalTime converterStringParaLocalTime(String hora) {
		return converterStringParaLocalTime(hora, FormatacaoUtils.FORMATADOR_HORA);
	}
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de hora no formato {@code HH:mm} para {@link LocalTime}
	 * 
	 * @param hora - {@link String}
	 * @return {@code LocalTime}
	 */
	public static LocalTime converterStringParaLocalTimeHoraMinuto(String hora) {
		return converterStringParaLocalTime(hora, FormatacaoUtils.FORMATADOR_HORA_MINUTO);
	}

	/**
	 * Método responsável por converter uma {@link String}
	 * de hora para {@link LocalTime} conforme o tipo de formatação
	 * do {@link DateTimeFormatter}
	 * 
	 * @param hora - {@link String}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code LocalTime}
	 */
	public static LocalTime converterStringParaLocalTime(String hora, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(hora))
			throw new NullPointerException("A hora não pode ser nula!");
		
		try {
			return LocalTime.parse(hora, formatter);
		}
		catch (DateTimeParseException e) {
			throw new DateTimeException("Erro ao converter a hora para LocalTime. "
					+ "Formato da hora ou DateTimeFormatter inválido!");
		}
	}
}
