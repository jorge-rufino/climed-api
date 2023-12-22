package com.rufino.climedapi.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    //Pega as mensagens do arquivo "messages.properties"
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(EntidadeDuplicadaException.class)
    public ResponseEntity<?> handlerEntidadeDuplicadaException(EntidadeDuplicadaException e) {

        Problema problema = problemaFactory(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);

        return ResponseEntity.badRequest().body(problema);
    }

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<?> handlerEmailDuplicadoException(EmailDuplicadoException e) {

        Problema problema = problemaFactory(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);

        return ResponseEntity.badRequest().body(problema);
    }

    //Validaçao do @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Problema.Campo> campos = new ArrayList<>();

        //Pega todos erros disparados na requisição
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String messagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, messagem));

        }

        String titulo = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente!";
        Problema problema = problemaFactory(status.value(), titulo, campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }

    private Problema problemaFactory(Integer status, String titulo, List<Problema.Campo> campos){
        Problema problema = new Problema();
        problema.setStatus(status);
        problema.setTitulo(titulo);
        problema.setDataHora(OffsetDateTime.now());
        problema.setCampos(campos);

        return problema;
    }
}
