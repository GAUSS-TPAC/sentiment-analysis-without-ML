package com.example.sa_backend.service;

import com.example.sa_backend.entites.Client;
import com.example.sa_backend.entites.Sentiment;
import com.example.sa_backend.enums.TypeSentiments;
import com.example.sa_backend.repository.SentimentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class SentimentService {

    private SentimentRepository sentimentRepository;
    private ClientService clientService;


    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(Sentiment sentiment){
        Client client= this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        //analyse
        if(sentiment.getText().contains("pas")){
            sentiment.setType(TypeSentiments.NEGATIF);
        }else {
            sentiment.setType(TypeSentiments.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiments type) {
        if(type == null){
            return this.sentimentRepository.findAll();
        }
        return this.sentimentRepository.findByType(type);
    }


    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}