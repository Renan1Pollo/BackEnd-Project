package br.edu.fema.projetopadrao.seguranca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.projetopadrao.seguranca.modelos.Usuario;

public interface LoginRepository extends JpaRepository<Usuario, String> {

	public Optional<Usuario> findByLogin(String login);

	public Optional<Usuario> findById(Long idUsuario);

	public Optional<Usuario> findByAccessTokenHashAndAccessTokenAtual(String tokenHash, String token);
}
