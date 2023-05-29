package br.edu.fema.projetopadrao.pessoa.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.projetopadrao.pessoa.dto.PessoaDTO;
import br.edu.fema.projetopadrao.pessoa.enums.Sexo;
import br.edu.fema.projetopadrao.pessoa.model.Pessoa;
import br.edu.fema.projetopadrao.pessoa.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        return this.pessoaService.listarPessoas();
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> listarPessoasPorId(@PathVariable Long idPessoa) {
        return this.pessoaService.listarPessoasPorId(idPessoa);
    }

    @GetMapping("/buscarPessoasCasadasJuridicas")
    public ResponseEntity<List<PessoaDTO>> listarPessoasCasadasEJuridicas() {
        return this.pessoaService.listarPessoasCasadasEJuridicas();
    }

    @GetMapping("/buscarPorOrdemDeNascimento")
    public ResponseEntity<List<PessoaDTO>> listarPessoasPorOrdemDeNascimento() {
        return this.pessoaService.listarPessoasPorOrdemDeNascimento();
    }

    @GetMapping("/buscarPorOrdemDeNome")
    public ResponseEntity<List<PessoaDTO>> listarPessoasPorOrdemNome() {
        return this.pessoaService.listarPessoasPorOrdemNome();
    }

    @GetMapping("/buscarPessoasFisicas")
    public ResponseEntity<List<PessoaDTO>> listarPessoasFisicas() {
        return this.pessoaService.listarPessoasFisicas();
    }

    @GetMapping("/buscarPorDataDeCadastro")
    public ResponseEntity<List<PessoaDTO>> listarPessoasPorDataDeCadastro() {
        return this.pessoaService.listarPessoasPorDataDeCadastro();
    }

    @GetMapping("/buscarUltimaPessoaCadastrada")
    public ResponseEntity<PessoaDTO> listarUltimaPessoaCadastrada() {
        return this.pessoaService.listarUltimaPessoaCadastrada();
    }

    @GetMapping("/buscarPessoasSeparadasPorSexo")
    public ResponseEntity<Map<Sexo, Long>> listarPessoasSeparadasPorSexo() {
        return this.pessoaService.listarPessoasSeparadasPorSexo();
    }

    @GetMapping("/buscarPessoasAgrupadasPorAno")
    public ResponseEntity<Map<LocalDate, List<Pessoa>>> listarPessoasAgrupadasPorAno() {
        return this.pessoaService.listarPessoasAgrupadasPorAno();
    }

    @GetMapping("/buscarPrimeiraPessoaCadastrada")
    public ResponseEntity<Optional<LocalDate>> listarPrimeiraPessoaCadastrada() {
        return this.pessoaService.listarPrimeiraPessoaCadastrada();
    }

    // @GetMapping("/buscarPrimeiraPessoaCadastrada")
    // public ResponseEntity<Optional<LocalDate>> listarPrimeiraPessoaCadastrada() {
    //     return this.pessoaService.listarPrimeiraPessoaCadastrada();
    // }
}
