package com.example.sa_backend.repository;

import com.example.sa_backend.entites.Sentiment;
import com.example.sa_backend.enums.TypeSentiments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

    List<Sentiment> findByType(TypeSentiments type);
}
