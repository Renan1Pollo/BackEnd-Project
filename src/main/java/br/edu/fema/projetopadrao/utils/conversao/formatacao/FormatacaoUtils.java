package br.edu.fema.projetopadrao.utils.conversao.formatacao;

import java.text.Collator;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 * Classe responsável por conter os padrões de
 * formatações utilizados para conversões de
 * data e/ou hora e para casos onde precisa levar
 * em consideração a localização para ordenações,
 * por exemplo
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 *
 */
public final class FormatacaoUtils {

	public static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	public static final DateTimeFormatter FORMATADOR_DATA_HORA_MINUTO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final DateTimeFormatter FORMATADOR_MES_ANO = DateTimeFormatter.ofPattern("MM/yyyy");
	
	public static final DateTimeFormatter FORMATADOR_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final DateTimeFormatter FORMATADOR_HORA_MINUTO = DateTimeFormatter.ofPattern("HH:mm");

	public static final Locale LOCALE_BR = new Locale("pt", "BR");
	
	/**
	 * Utilizado para ordenação de campos que precisa levar
	 * em consideração a acentuação de acordo com a localização
	 * especificada
	 */
	public static final Collator COLLATOR = Collator.getInstance(LOCALE_BR);
}
