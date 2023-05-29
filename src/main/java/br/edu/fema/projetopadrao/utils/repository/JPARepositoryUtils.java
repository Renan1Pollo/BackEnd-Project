package br.edu.fema.projetopadrao.utils.repository;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.projetopadrao.exception.custom.ObjectNotFoundException;

/**
 * Classe responsável por trabalhar de forma
 * genérica com JPA em Querys recorrentemente
 * utilizadas
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 26/07/2022
 * @version 1.1 - 08/08/2022
 *
 */
public final class JPARepositoryUtils {


	/**
	 * Método responsável por procurar um objeto
	 * no banco de dados de acordo com o ID
	 * 
	 * @param <T> - Tipo da Entidade
	 * @param <ID> - Tipo do ID da Entidade
	 * @param jpaRepository - {@link JpaRepository}
	 * @param classeDaEntidade - {@link Class}
	 * @param id - ID para buscar no banco de dados
	 * @return T - Entidade
	 */
	public static <T, ID> T verificarSeObjetoExiste(JpaRepository<T, ID> jpaRepository, Class<T> classeDaEntidade, ID id) {
		String nomeEntidade = classeDaEntidade.getSimpleName();
		
		if (Objects.isNull(id))
			throw new NullPointerException("O ID de " + nomeEntidade 
				+ " não pode ser nulo!");
		
		Optional<T> entidadeOptional = jpaRepository.findById(id);
		
		if (entidadeOptional.isPresent())
			return entidadeOptional.get();
		
		throw new ObjectNotFoundException(nomeEntidade + " não encontrado(a)!");
	}
}
