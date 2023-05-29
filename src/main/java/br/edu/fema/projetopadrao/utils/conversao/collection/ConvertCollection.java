package br.edu.fema.projetopadrao.utils.conversao.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 
 * Classe responsável por realizar a conversão
 * de uma coleção de entrada para uma nova coleção
 * de saída, podendo ou não ser ordenada
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 *
 */
public final class ConvertCollection {	
	
	/**
	 * Método responsável por converter uma coleção em uma nova {@link List} <br>
	 * Este método permite selecionar a classe que a interface {@link List} implementará
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @param supplier - Tipo da classe que implementa a interface {@link List}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> convertToList(Collection<E> collection, 
			Function<E, T> function, Supplier<List<T>> supplier) {
		
		return collection.stream().map(function::apply)
				.collect(supplier, List::add, List::addAll);
	}
	
	/**
	 * Método responsável por converter uma coleção em uma nova {@link List} <br>
	 * A implementação padrão da interface {@link List} utilizada é a {@link ArrayList}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> convertToList(Collection<E> collection, 
			Function<E, T> function) {
		
		return convertToList(collection, function, ArrayList::new);
	}
	
	/**
	 * Método responsável por converter a coleção e ordená-la com
	 * base no {@code Comparator<T>} <br>
	 * Este método permite selecionar a classe que a interface {@link List} implementará
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @param comparator - {@code Comparator<T>} do tipo da classe que será retornado
	 * pela nova {@link List}
	 * @param supplier - Tipo da classe que implementa a interface {@link List}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> convertAndSortList(
			Collection<E> collection, Function<E, T> function,
			Comparator<T> comparator, Supplier<List<T>> supplier) {
		
		return collection.stream().map(function::apply)
				.sorted(comparator).collect(supplier, List::add, List::addAll);
	}
	
	/**
	 * Método responsável por converter a coleção e ordená-la com
	 * base no {@code Comparator<T>}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @param comparator - {@code Comparator<T>} do tipo da classe que será retornado
	 * pela nova {@link List}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> convertAndSortList(
			Collection<E> collection, Function<E, T> function,
			Comparator<T> comparator) {
		
		return convertAndSortList(collection, function, comparator, ArrayList::new);
	}
	
	/**
	 * Método responsável por ordenar a coleção de entrada e depois realizar
	 * a sua conversão para {@link List} <br>
	 * Este método permite selecionar a classe que a interface {@link List} implementará
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param comparator - {@code Comparator<E>} do tipo da Entidade
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @param supplier - Tipo da classe que implementa a interface {@link List}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> sortAndConvertList(
			Collection<E> collection, Comparator<E> comparator, 
			Function<E, T> function, Supplier<List<T>> supplier) {
		
		return collection.stream().sorted(comparator).map(function::apply)
				.collect(supplier, List::add, List::addAll);
	}
	
	/**
	 * Método responsável por ordenar a coleção de entrada e depois realizar
	 * a sua conversão para {@link List}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param comparator - {@code Comparator<E>} do tipo da Entidade
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code List<T>}
	 * @return {@code List<T>}
	 */
	public static <E, T> List<T> sortAndConvertList(
			Collection<E> collection, Comparator<E> comparator, 
			Function<E, T> function) {
		
		return sortAndConvertList(collection, comparator, function, ArrayList::new);
	}
	
	
	/**
	 * Método responsável por converter uma coleção em um novo {@link Set} <br>
	 * Este método permite selecionar a classe que a interface {@link Set} implementará
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code Set<T>}
	 * @param supplier - Tipo da classe que implementa a interface {@link Set}
	 * @return {@code Set<T>}
	 */
	public static <E, T> Set<T> convertToSet(Collection<E> collection, 
			Function<E, T> function, Supplier<Set<T>> supplier) {
		
		return collection.stream().map(function::apply)
				.collect(supplier, Set::add, Set::addAll);
	}
	
	/**
	 * Método responsável por converter uma coleção em um novo {@link Set} <br>
	 * A implementação padrão da interface {@link Set} utilizada é a {@link HashSet}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code Set<T>}
	 * @return {@code Set<T>}
	 */
	public static <E, T> Set<T> convertToSet(Collection<E> collection, 
			Function<E, T> function) {
		
		return convertToSet(collection, function, HashSet::new);
	}
	
	/**
	 * Método responsável por converter a coleção e ordená-la com
	 * base no {@code Comparator<T>} <br>
	 * A implementação padrão da interface {@link Set} utilizada é a {@link LinkedHashSet}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code Set<T>}
	 * @param comparator - {@code Comparator<T>} do tipo da classe que será retornado
	 * pelo novo {@link Set}
	 * @return {@code Set<T>}
	 */
	public static <E, T> Set<T> convertAndSortSet(
			Collection<E> collection, Function<E, T> function,
			Comparator<T> comparator) {
		
		return collection.stream().map(function::apply).sorted(comparator)
				.collect(LinkedHashSet::new, Set::add, Set::addAll);
	}
	
	/**
	 * Método responsável por ordenar a coleção de entrada e depois realizar
	 * a sua conversão para {@link Set}
	 * A implementação padrão da interface {@link Set} utilizada é a {@link LinkedHashSet}
	 * 
	 * @param <E> - Tipo da Classe da Entidade
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param comparator - {@code Comparator<E>} do tipo da Entidade
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code Set<T>}
	 * pelo novo {@link Set}
	 * @return {@code Set<T>}
	 */
	public static <E, T> Set<T> sortAndConvertSet(
			Collection<E> collection, Comparator<E> comparator, 
			Function<E, T> function) {
		
		return collection.stream().sorted(comparator).map(function::apply)
				.collect(LinkedHashSet::new, Set::add, Set::addAll);
	}
	
	/**
	 * Método responsável por converter a coleção e ordená-la com
	 * base na interface {@code Comparable<T>} que a classe {@code T} implementa <br>
	 * A implementação padrão da interface {@link Set} utilizada é a {@link TreeSet}
	 * 
	 * @param <E> - Tipo da Classe da Entidade que deve implementar a interface {@link Comparable}
	 * @param <T> - Tipo da Classe que será retornado após conversão
	 * @param collection - Coleção de entrada a ser convertida
	 * @param function - Função que realizará a conversão da {@code Collection<E>}
	 * para {@code Set<T>}
	 * @return {@code Set<T>}
	 */
	public static <E, T extends Comparable<T>> Set<T> convertAndSortTreeSet(
			Collection<E> collection, Function<E, T> function) {
		
		return convertToSet(collection, function, TreeSet::new);
	}
}
