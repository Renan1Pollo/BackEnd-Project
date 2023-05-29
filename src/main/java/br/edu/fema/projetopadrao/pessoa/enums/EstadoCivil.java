package br.edu.fema.projetopadrao.pessoa.enums;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.GettersEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EstadoCivil implements GettersEnum<String> {
    
    SOLTEIRO("S", "Solteiro(a)"),
    CASADO("C", "Casado(a)"),
    VIUVO("V", "Viúvo(a)"),
    DIVORCIADO("D", "Divorciado(a)");

    private String valor;
    private String descricao;
}
