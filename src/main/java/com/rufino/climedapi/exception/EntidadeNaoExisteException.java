package com.rufino.climedapi.exception;

public class EntidadeNaoExisteException extends RuntimeException{

    public EntidadeNaoExisteException(String message) {
        super(message);
    }
}
