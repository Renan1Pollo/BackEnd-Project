package br.edu.fema.projetopadrao.pessoa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.fema.projetopadrao.pessoa.enums.EstadoCivil;
import br.edu.fema.projetopadrao.pessoa.enums.Sexo;
import br.edu.fema.projetopadrao.pessoa.enums.TipoPessoa;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa", schema = "projeto_exemplo_estagiarios")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo 'nome' não pode  ser nulo/vazio!")
    @Size(max = 70, message = "O campo 'nome' deve ter no máximo {max} caracteres!")
    private String nome;

    @NotNull(message = "O campo 'sexo' não pode ser nulo!")
    private Sexo sexo;

    @Column(name = "estado_civil")
    @NotNull(message = "O campo 'estadoCivil' não pode ser nulo!")
    private EstadoCivil estadoCivil;
    
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @Column(name = "data_nascimento")
    @NotEmpty(message = "O campo 'dataNascimento' não pode  ser nulo/vazio!")
    @Size(max = 10, message = "O campo 'dataNascimento' deve ter no máximo {max} caracteres!")
    private String dataNascimento;

    @Size(max = 14, message = "O campo 'cpf' deve ter no máximo {max} caracteres!")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "data_cadastro")
    @NotNull(message = "O campo 'dataCadastro' não pode ser nulo!")
    private LocalDate dataCadastro;

    @Column(name = "id_endereco")
    private Long idEndereco;

}
