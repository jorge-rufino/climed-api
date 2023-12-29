package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoReduzidoDTO {

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;
}
