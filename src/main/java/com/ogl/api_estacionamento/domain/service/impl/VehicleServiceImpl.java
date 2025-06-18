package com.ogl.api_estacionamento.domain.service.impl;

import com.ogl.api_estacionamento.domain.controller.exception.PlacaAlreadyUsedException;
import com.ogl.api_estacionamento.domain.controller.exception.VehicleNotFoundException;
import com.ogl.api_estacionamento.domain.model.Vehicle;
import com.ogl.api_estacionamento.domain.repository.VehicleRepository;
import com.ogl.api_estacionamento.domain.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle create(Vehicle vehicle) {
        if (vehicleRepository.existsByPlaca(vehicle.getPlaca())) {
            throw new PlacaAlreadyUsedException(vehicle.getPlaca());
        }
        return vehicleRepository.save(vehicle);
    }

}
