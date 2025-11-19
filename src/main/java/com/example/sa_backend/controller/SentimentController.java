package com.example.sa_backend.controller;

import com.example.sa_backend.entites.Sentiment;
import com.example.sa_backend.enums.TypeSentiments;
import com.example.sa_backend.service.SentimentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path="sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required=false) TypeSentiments type){
        System.out.println("recher des sentiments : ");
        return this.sentimentService.rechercher(type);
    }

    @DeleteMapping(path = "{id}")
    public void suprimer(@PathVariable int id){
    this.sentimentService.supprimer(id);
    }
}
