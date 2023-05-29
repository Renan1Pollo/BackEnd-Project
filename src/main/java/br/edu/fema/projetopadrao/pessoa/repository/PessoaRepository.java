package br.edu.fema.projetopadrao.pessoa.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.projetopadrao.pessoa.enums.EstadoCivil;
import br.edu.fema.projetopadrao.pessoa.enums.TipoPessoa;
import br.edu.fema.projetopadrao.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    List<Pessoa> findByEstadoCivilAndTipoPessoa(EstadoCivil estadoCivil, TipoPessoa tipoPessoa);
    List<Pessoa> findAllByOrderByDataNascimentoAsc();
    List<Pessoa> findAllByOrderByNomeAsc();
    List<Pessoa> findByCpfNotNull();
    List<Pessoa> findAllByDataCadastroAfter(LocalDate data);
    Optional<Pessoa> findFirstByOrderByDataCadastroDesc();

}
