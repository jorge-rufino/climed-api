package com.rufino.climedapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    private String complemento;

    private String numero;
}
