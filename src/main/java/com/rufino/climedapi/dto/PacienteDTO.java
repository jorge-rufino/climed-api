package com.rufino.climedapi.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String telefone;

    @Embedded
    @Valid
    private EnderecoDTO endereco;
}
