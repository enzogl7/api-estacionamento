package com.ogl.api_estacionamento.domain.service;

import com.ogl.api_estacionamento.domain.model.Client;

import java.util.List;

public interface ClientService {
    Client findById(Long id);
    Client create(Client client);
    List<Client> findAll();
}
