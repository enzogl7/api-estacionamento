package com.ogl.api_estacionamento.domain.service;

import com.ogl.api_estacionamento.domain.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle findById(Long id);
    List<Vehicle> findAll();
    Vehicle create(Vehicle vehicle);
}
