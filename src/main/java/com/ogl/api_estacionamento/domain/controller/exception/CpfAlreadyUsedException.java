package com.ogl.api_estacionamento.domain.controller.exception;

public class CpfAlreadyUsedException extends RuntimeException {
    public CpfAlreadyUsedException(String cpf) {
        super("CPF já cadastrado: " + cpf);
    }
}
