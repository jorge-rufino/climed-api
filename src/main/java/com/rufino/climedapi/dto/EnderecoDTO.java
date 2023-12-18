package com.rufino.climedapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,

        String numero
) {
}
