package com.ogl.api_estacionamento.domain.controller.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super("Vehicle not found for the given ID");
    }
}
