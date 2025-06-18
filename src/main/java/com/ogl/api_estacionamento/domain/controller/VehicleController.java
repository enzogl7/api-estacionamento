package com.ogl.api_estacionamento.domain.controller;

import com.ogl.api_estacionamento.domain.model.Client;
import com.ogl.api_estacionamento.domain.model.Vehicle;
import com.ogl.api_estacionamento.domain.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable("id") Long id) {
        Vehicle vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        List<Vehicle> allVehicles = vehicleService.findAll();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Vehicle vehicleToCreate) {
        var vehicleCreated = vehicleService.create(vehicleToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicleCreated.getId()).toUri();
        return ResponseEntity.created(location).body(vehicleCreated);
    }
}
