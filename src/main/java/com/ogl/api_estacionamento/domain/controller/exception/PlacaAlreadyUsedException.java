package com.ogl.api_estacionamento.domain.controller.exception;

public class PlacaAlreadyUsedException extends RuntimeException {
    public PlacaAlreadyUsedException(String placa) {
        super("License plate already used: " + placa);
    }
}
