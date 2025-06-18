package com.ogl.api_estacionamento.domain.controller.exception;

import java.util.function.Supplier;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found with the given ID");
    }
}
