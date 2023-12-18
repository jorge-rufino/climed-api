package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")   //Somente digitos, e minimo de 4 e maximo de 6 digitos
        String crm,

        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        EnderecoDTO endereco
        ) {
}
