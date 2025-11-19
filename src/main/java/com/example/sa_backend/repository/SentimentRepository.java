package com.example.sa_backend.repository;

import com.example.sa_backend.entites.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

}
