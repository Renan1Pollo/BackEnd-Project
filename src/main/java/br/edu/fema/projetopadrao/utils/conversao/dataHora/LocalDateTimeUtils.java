package br.edu.fema.projetopadrao.utils.conversao.dataHora;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import org.springframework.lang.NonNull;

import br.edu.fema.projetopadrao.utils.conversao.formatacao.FormatacaoUtils;

/**
 * 
 * Classe responsável por manipular a classe de data e hora
 * {@link LocalDateTime} utilizando diversas formatações
 * e conversões entre {@link LocalDateTime} e {@link String}
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.1 - 28/07/2022
 *
 */
public final class LocalDateTimeUtils {

	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * com a data e hora atual para {@link String} no formato
	 * {@code dd/MM/yyyy HH:mm:ss}
	 * 
	 * @return {@code String}
	 */
	public static String converterLocalDateTimeAtualParaString() {
		return converterLocalDateTimeParaString(LocalDateTime.now());
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * com a data e hora atual e os segundos zerados para 
	 * {@link String} no formato {@code dd/MM/yyyy HH:mm:ss}
	 * 
	 * @return {@code String}
	 * 
	 * @since 1.1
	 */
	public static String converterLocalDateTimeAtualComSegundosZeradosParaString() {
		return converterLocalDateTimeComSegundosZeradosParaString(LocalDateTime.now());
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * com a data e hora atual para {@link String} no formato
	 * {@code dd/MM/yyyy HH:mm}
	 * 
	 * @return {@code String}
	 */
	public static String converterLocalDateTimeAtualHoraMinutoParaString() {
		return converterLocalDateTimeParaString(LocalDateTime.now(), FormatacaoUtils.FORMATADOR_DATA_HORA_MINUTO);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * para o formato {@code dd/MM/yyyy HH:mm:ss}
	 * 
	 * @param dataHora - {@link LocalDateTime}
	 * @return {@code String}
	 */
	public static String converterLocalDateTimeParaString(LocalDateTime dataHora) {
		return converterLocalDateTimeParaString(dataHora, FormatacaoUtils.FORMATADOR_DATA_HORA);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * com a data e hora e os segundos zerados para {@link String} 
	 * no formato {@code dd/MM/yyyy HH:mm:ss}
	 * 
	 * @return {@code String}
	 * 
	 * @since 1.1
	 */
	public static String converterLocalDateTimeComSegundosZeradosParaString(LocalDateTime dataHora) {
		return converterLocalDateTimeParaString(dataHora, FormatacaoUtils.FORMATADOR_DATA_HORA_MINUTO) + ":00";
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * para o formato {@code dd/MM/yyyy HH:mm}
	 * 
	 * @param dataHora - {@link LocalDateTime}
	 * @return {@code String}
	 */
	public static String converterLocalDateTimeHoraMinutoParaString(LocalDateTime dataHora) {
		return converterLocalDateTimeParaString(dataHora, FormatacaoUtils.FORMATADOR_DATA_HORA_MINUTO);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDateTime}
	 * com base no tipo de formatação do {@link DateTimeFormatter}
	 * 
	 * @param dataHora - {@link LocalDateTime}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code String}
	 */
	public static String converterLocalDateTimeParaString(LocalDateTime dataHora, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(dataHora))
			throw new NullPointerException("A dataHora não pode ser nula!");
		
		try {
			return formatter.format(dataHora);
		}
		catch (DateTimeException e) {
			throw new DateTimeException("DateTimeFormatter inválido!");
		}
	}
	
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de data e hora no formato {@code dd/MM/yyyy HH:mm:ss} 
	 * para {@link LocalDateTime}
	 * 
	 * @param dataHora - {@link String}
	 * @return {@code LocalDateTime}
	 */
	public static LocalDateTime converterStringParaLocalDateTime(String dataHora) {
		return converterStringParaLocalDateTime(dataHora, FormatacaoUtils.FORMATADOR_DATA_HORA);
	}
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de data e hora no formato {@code dd/MM/yyyy HH:mm} 
	 * para {@link LocalDateTime}
	 * 
	 * @param dataHoraMinuto - {@link String}
	 * @return {@code LocalDateTime}
	 */
	public static LocalDateTime converterStringParaLocalDateTimeHoraMinuto(String dataHoraMinuto) {
		return converterStringParaLocalDateTime(dataHoraMinuto, FormatacaoUtils.FORMATADOR_DATA_HORA_MINUTO);
	}
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de data e hora para {@link LocalDateTime} conforme o tipo de formatação
	 * do {@link DateTimeFormatter}
	 * 
	 * @param dataHora - {@link String}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code LocalDateTime}
	 */
	public static LocalDateTime converterStringParaLocalDateTime(String dataHora, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(dataHora))
			throw new NullPointerException("A dataHora não pode ser nula!");
		
		try {
			return LocalDateTime.parse(dataHora, formatter);
		}
		catch (DateTimeParseException e) {
			throw new DateTimeException("Erro ao converter a dataHora para LocalDateTime. "
					+ "Formato da dataHora ou DateTimeFormatter inválido!");
		}
	}
}
