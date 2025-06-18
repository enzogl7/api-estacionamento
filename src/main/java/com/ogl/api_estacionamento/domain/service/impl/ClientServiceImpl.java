package com.ogl.api_estacionamento.domain.service.impl;

import com.ogl.api_estacionamento.domain.controller.exception.ClientNotFoundException;
import com.ogl.api_estacionamento.domain.model.Client;
import com.ogl.api_estacionamento.domain.repository.ClientRepository;
import com.ogl.api_estacionamento.domain.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client create(Client clientToCreate) {
        if (clientRepository.existsByCpf(clientToCreate.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado: " + clientToCreate.getCpf());
        }
        return clientRepository.save(clientToCreate);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
