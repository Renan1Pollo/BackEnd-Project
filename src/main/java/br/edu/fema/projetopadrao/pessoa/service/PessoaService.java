package br.edu.fema.projetopadrao.pessoa.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.fema.projetopadrao.exception.custom.ObjectNotFoundException;
import br.edu.fema.projetopadrao.pessoa.dto.PessoaDTO;
import br.edu.fema.projetopadrao.pessoa.enums.EstadoCivil;
import br.edu.fema.projetopadrao.pessoa.enums.Sexo;
import br.edu.fema.projetopadrao.pessoa.enums.TipoPessoa;
import br.edu.fema.projetopadrao.pessoa.model.Pessoa;
import br.edu.fema.projetopadrao.pessoa.repository.PessoaRepository;
import br.edu.fema.projetopadrao.utils.repository.JPARepositoryUtils;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<PessoaDTO> listarPessoasPorId(Long idPessoa) {
        Pessoa pessoa = JPARepositoryUtils.verificarSeObjetoExiste(pessoaRepository, Pessoa.class, idPessoa);
        return ResponseEntity.ok(new PessoaDTO(pessoa));
    }

    public ResponseEntity<List<PessoaDTO>> listarPessoasCasadasEJuridicas() {
        List<Pessoa> pessoas = pessoaRepository.findByEstadoCivilAndTipoPessoa(EstadoCivil.CASADO, TipoPessoa.JURIDICA);
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<List<PessoaDTO>> listarPessoasPorOrdemDeNascimento() {
        List<Pessoa> pessoas = pessoaRepository.findAllByOrderByDataNascimentoAsc();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<List<PessoaDTO>> listarPessoasPorOrdemNome() {
        List<Pessoa> pessoas = pessoaRepository.findAllByOrderByNomeAsc();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<List<PessoaDTO>> listarPessoasFisicas() {
        List<Pessoa> pessoas = pessoaRepository.findByCpfNotNull();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<List<PessoaDTO>> listarPessoasPorDataDeCadastro() {
        LocalDate data = LocalDate.of(2020, 01, 01);
        List<Pessoa> pessoas = pessoaRepository.findAllByDataCadastroAfter(data);
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }

    public ResponseEntity<PessoaDTO> listarUltimaPessoaCadastrada() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        Optional<Pessoa> optionalPessoa = pessoas.stream()
                .max(Comparator.comparing(Pessoa::getDataCadastro));
        if (!optionalPessoa.isPresent())
            throw new ObjectNotFoundException("Não foi possivel encontrar a ultima pessoa cadastrada!");

        return ResponseEntity.ok(new PessoaDTO(optionalPessoa.get()));
    }

    public ResponseEntity<Map<Sexo, Long>> listarPessoasSeparadasPorSexo() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        Map<Sexo, Long> totalPorSexo = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getSexo, Collectors.counting()));
        return ResponseEntity.ok(totalPorSexo);
    }

    public ResponseEntity<Map<LocalDate, List<Pessoa>>> listarPessoasAgrupadasPorAno() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        Map<LocalDate, List<Pessoa>> pessoasPorAno = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getDataCadastro));

        return ResponseEntity.ok(pessoasPorAno);
    }

    public ResponseEntity<Optional<LocalDate>> listarPrimeiraPessoaCadastrada() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        Optional<LocalDate> primeiraPessoa = pessoas.stream()
                .map(Pessoa::getDataCadastro)
                .min(LocalDate::compareTo);
        if (!primeiraPessoa.isPresent())
            throw new ObjectNotFoundException("Não foi possivel encontrar a ultima pessoa cadastrada!");

        return ResponseEntity.ok(primeiraPessoa);
    }

}
