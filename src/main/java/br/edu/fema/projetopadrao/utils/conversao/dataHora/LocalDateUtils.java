package br.edu.fema.projetopadrao.utils.conversao.dataHora;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import org.springframework.lang.NonNull;

import br.edu.fema.projetopadrao.utils.conversao.formatacao.FormatacaoUtils;

/**
 * 
 * Classe responsável por manipular a classe de data
 * {@link LocalDate} utilizando diversas formatações
 * e conversões entre {@link LocalDate} e {@link String}
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 *
 */
public final class LocalDateUtils {
	
	/**
	 * Método responsável por converter um {@link LocalDate}
	 * com a data atual para {@link String} no formato {@code dd/MM/yyyy}
	 * 
	 * @return {@code String}
	 */
	public static String converterLocalDateAtualParaString() {
		return converterLocalDateParaString(LocalDate.now(), FormatacaoUtils.FORMATADOR_DATA);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDate}
	 * com a data atual para {@link String} no formato {@code MM/yyyy}
	 * 
	 * @return {@code String}
	 */
	public static String converterMesAnoAtualParaString() {
		return converterLocalDateParaString(LocalDate.now(), FormatacaoUtils.FORMATADOR_MES_ANO);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDate}
	 * para o formato {@code dd/MM/yyyy}
	 * 
	 * @param data - {@link LocalDate}
	 * @return {@code String}
	 */
	public static String converterLocalDateParaString(LocalDate data) {
		return converterLocalDateParaString(data, FormatacaoUtils.FORMATADOR_DATA);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDate}
	 * para o formato {@code MM/yyyy}
	 * 
	 * @param data - {@link LocalDate}
	 * @return {@code String}
	 */
	public static String converterMesAnoParaString(LocalDate data) {
		return converterLocalDateParaString(data, FormatacaoUtils.FORMATADOR_MES_ANO);
	}
	
	/**
	 * Método responsável por converter um {@link LocalDate}
	 * com base no tipo de formatação do {@link DateTimeFormatter}
	 * 
	 * @param data - {@link LocalDate}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code String}
	 */
	public static String converterLocalDateParaString(LocalDate data, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(data))
			throw new NullPointerException("A data não pode ser nula!");
		
		try {
			return formatter.format(data);
		}
		catch (DateTimeException e) {
			throw new DateTimeException("DateTimeFormatter inválido!");
		}
	}
	
	
	/**
	 * Método responsável por converter uma {@link String}
	 * de data no formato {@code dd/MM/yyyy} para {@link LocalDate}
	 * 
	 * @param data - {@link LocalDate}
	 * @return {@code LocalDate}
	 */
	public static LocalDate converterStringParaLocalDate(String data) {
		return converterStringParaLocalDate(data, FormatacaoUtils.FORMATADOR_DATA);
	}

	/**
	 * Método responsável por converter uma {@link String}
	 * de data para {@link LocalDate} conforme o tipo de formatação
	 * do {@link DateTimeFormatter}
	 * 
	 * @param data - {@link LocalDate}
	 * @param formatter - {@link DateTimeFormatter}
	 * @return {@code LocalDate}
	 */
	public static LocalDate converterStringParaLocalDate(String data, @NonNull DateTimeFormatter formatter) {
		if (Objects.isNull(data))
			throw new NullPointerException("A data não pode ser nula!");
		
		try {
			return LocalDate.parse(data, formatter);
		}
		catch (DateTimeParseException e) {
			throw new DateTimeException("Erro ao converter a data para LocalDate. "
					+ "Formato da data ou DateTimeFormatter inválido!");
		}
	}
}
