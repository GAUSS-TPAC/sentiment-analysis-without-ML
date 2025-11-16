package com.example.sa_backend.controller;

import com.example.sa_backend.entites.Client;
import com.example.sa_backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping (path = "client")
public class ClientController {

    private ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes= APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){
        this.clientService.creer(client);
    }
}
