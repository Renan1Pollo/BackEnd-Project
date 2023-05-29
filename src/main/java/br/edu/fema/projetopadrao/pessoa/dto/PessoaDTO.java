package br.edu.fema.projetopadrao.pessoa.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.fema.projetopadrao.pessoa.enums.EstadoCivil;
import br.edu.fema.projetopadrao.pessoa.enums.Sexo;
import br.edu.fema.projetopadrao.pessoa.enums.TipoPessoa;
import br.edu.fema.projetopadrao.pessoa.model.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private Sexo sexo;
    private EstadoCivil estadoCivil;
    private TipoPessoa tipoPessoa;
    private String dataNascimento;
    private String cpf;
    private String cnpj;
    private LocalDate dataCadastro;
    private Long idEndereco;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.estadoCivil = pessoa.getEstadoCivil();
        this.tipoPessoa = pessoa.getTipoPessoa();
        this.dataNascimento = pessoa.getDataNascimento();
        this.cpf = pessoa.getCpf();
        this.cnpj = pessoa.getCnpj();
        this.dataCadastro = pessoa.getDataCadastro();
        this.idEndereco = pessoa.getIdEndereco();
    }

    public static List<PessoaDTO> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }

}
