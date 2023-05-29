package br.edu.fema.projetopadrao.utils.conversao.dataHora;

import java.time.Duration;

/**
 * 
 * Classe responsável por manipular a classe {@link Duration}
 * a fim de gerar durações em diferentes formatos}
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 26/07/2022
 * @version 1.0
 *
 */
public final class DurationUtils {
	
	
	/**
	 * Método responsável por formatar a {@link Duration}
	 * no padrão de HH:mm:ss <br>
	 * A hora vai poder exceder o limite de 24h, já o minuto
	 * e segundo terão o valor entre 0-59
	 * 
	 * @param duration - {@link Duration}
	 * @return {@code String}
	 */
	public static String formatarDurationDeHorario(Duration duration) {
		return new StringBuilder()
			.append(formatarUnidadeDeTempo(duration.toHours()))
			.append(":")
			.append(formatarUnidadeDeTempo(duration.toMinutesPart()))
			.append(":")
			.append(formatarUnidadeDeTempo(duration.toSecondsPart()))
			.toString();
	}
	
	/**
	 * Método responsável por formatar a {@link Duration}
	 * no padrão de HH:mm <br>
	 * A hora vai poder exceder o limite de 24h, já o minuto
	 * terá o valor entre 0-59
	 * 
	 * @param duration - {@link Duration}
	 * @return {@code String}
	 */
	public static String formatarDurationParaHoraMinuto(Duration duration) {
		return new StringBuilder()
				.append(formatarUnidadeDeTempo(duration.toHours()))
				.append(":")
				.append(formatarUnidadeDeTempo(duration.toMinutesPart()))
				.toString();
	}
	
	/**
	 * Método responsável por formatar a {@link Duration}
	 * no padrão de mm:ss <br>
	 * O minuto e segundo terão valores entre 0-59
	 * 
	 * @param duration - {@link Duration}
	 * @return {@code String}
	 */
	public static String formatarDurationParaMinutoSegundo(Duration duration) {
		return new StringBuilder()
				.append(formatarUnidadeDeTempo(duration.toMinutesPart()))
				.append(":")
				.append(formatarUnidadeDeTempo(duration.toSecondsPart()))
				.toString();
	}
	
	/**
	 * Método responsável por formatar uma unidade
	 * de tempo ex: hora, minuto ou segundo para ter
	 * pelo menos dois digitos no valor gerado
	 * 
	 * @param unidadeDeTempo - long
	 * @return {@code String}
	 */
	public static String formatarUnidadeDeTempo(long unidadeDeTempo) {
		return unidadeDeTempo < 10L 
			? "0" + String.valueOf(unidadeDeTempo) 
			: String.valueOf(unidadeDeTempo);
	}
}
