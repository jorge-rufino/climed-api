package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoReduzidoDTO {
    private String nome;
    private String emai;
    private String crm;
    private String telefone;
    private Especialidade especialidade;
}
