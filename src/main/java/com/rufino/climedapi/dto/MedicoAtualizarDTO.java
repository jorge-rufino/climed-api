package com.rufino.climedapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoAtualizarDTO {

    private String nome;
    private String telefone;
    private EnderecoDTO endereco;
}
