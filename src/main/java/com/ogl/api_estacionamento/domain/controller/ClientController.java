package com.ogl.api_estacionamento.domain.controller;

import com.ogl.api_estacionamento.domain.model.Client;
import com.ogl.api_estacionamento.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        var client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        List<Client> allClients = clientService.findAll();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client clientToCreate) {
        var clientCreated = clientService.create(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientCreated.getId()).toUri();
        return ResponseEntity.created(location).body(clientCreated);
    }
}
