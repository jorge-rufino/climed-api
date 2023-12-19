package com.rufino.climedapi.dto;

import com.rufino.climedapi.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")   //Somente digitos, e minimo de 4 e maximo de 6 digitos
    private String crm;

    @NotBlank
    private String telefone;

    @NotNull
    private Especialidade especialidade;

    @NotNull
    @Valid
    private EnderecoDTO endereco;
}
