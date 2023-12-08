package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;

public record MedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoDTO endereco
        ) {
}
