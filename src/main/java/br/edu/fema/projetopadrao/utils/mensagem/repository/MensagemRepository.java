package br.edu.fema.projetopadrao.utils.mensagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.projetopadrao.utils.mensagem.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
