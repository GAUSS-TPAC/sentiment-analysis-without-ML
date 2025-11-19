package com.example.sa_backend.service;

import com.example.sa_backend.entites.Client;
import com.example.sa_backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){

        this.clientRepository.save(client);
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);

        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientACreer) {
        Client clientDanslaBDD = this.clientRepository.findByEmail(clientACreer.getEmail());
        if(clientDanslaBDD ==null){
            clientDanslaBDD = this.clientRepository.save(clientACreer);
        }
        return clientDanslaBDD;
    }
}
