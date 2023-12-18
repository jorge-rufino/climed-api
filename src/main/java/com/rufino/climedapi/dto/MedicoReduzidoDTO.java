package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;

public record MedicoReduzidoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
        ) {
}
