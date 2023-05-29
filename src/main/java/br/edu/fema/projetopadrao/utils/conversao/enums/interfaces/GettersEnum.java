package br.edu.fema.projetopadrao.utils.conversao.enums.interfaces;

/**
 *
 * Interface que contém os métodos de
 * {@link ValorEnum} e {@link DescricaoEnum}
 * utilizados para manipular Enums e flexibilizar
 * o envio dos dados destes Enums para o front
 * 
 * 
 * @param <E> - Tipo do valor do Enum
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 * 
 */
public interface GettersEnum<E> extends ValorEnum<E>, DescricaoEnum {

}
