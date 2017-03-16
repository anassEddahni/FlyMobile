package com.example.dit.com.example.dit.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DIT on 16/03/2017.
 */

public class Attribut implements Serializable {
    private String nom;
    private List<Article> articles;

    public Attribut() {
    }

    public Attribut(String nom, List<Article> articles) {

        this.nom = nom;
        this.articles = articles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
