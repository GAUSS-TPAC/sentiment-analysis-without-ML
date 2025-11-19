package com.example.sa_backend.service;

import com.example.sa_backend.entites.Client;
import com.example.sa_backend.entites.Sentiment;
import com.example.sa_backend.repository.SentimentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class SentimentService {

    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository) {
        this.sentimentRepository = sentimentRepository;
    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(Sentiment sentiment){
        Client client= this.clientService.lireOuCreer(sentiment.getClient());
        this.sentimentRepository.save(sentiment);
    }
}