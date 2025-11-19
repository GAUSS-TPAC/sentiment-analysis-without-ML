package com.example.sa_backend.entites;

import com.example.sa_backend.enums.TypeSentiments;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String text;
    private TypeSentiments type;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment(){

    }

    public Sentiment(int id, String text, TypeSentiments type, Client client) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeSentiments getType() {
        return type;
    }

    public void setType(TypeSentiments type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
