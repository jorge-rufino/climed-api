package com.rufino.climedapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class Problema {

    private Integer status;			//Numero de erro da requisição
    private String titulo;				//Título geral do erro

    private List<Campo> campos;			//Lista com o erros, contendo o nome e a mensagem de erro

    private OffsetDateTime dataHora;	//data e hora do erro

    @Getter
    @AllArgsConstructor
    public static class Campo{

        private String nome;
        private String mensagem;
    }
}
