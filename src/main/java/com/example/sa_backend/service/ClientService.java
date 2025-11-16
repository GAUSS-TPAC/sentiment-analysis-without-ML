package com.example.sa_backend.service;

import com.example.sa_backend.entites.Client;
import com.example.sa_backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){

    }
}
