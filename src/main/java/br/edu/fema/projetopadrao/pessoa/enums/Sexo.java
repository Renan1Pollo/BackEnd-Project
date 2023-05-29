package br.edu.fema.projetopadrao.pessoa.enums;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ValorEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Sexo implements ValorEnum<String> {

    FEMININO("F"),
    MASCULINO("M");

    private String valor;
}
