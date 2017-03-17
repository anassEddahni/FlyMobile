package com.example.dit.com.example.dit.entities;

import java.io.Serializable;

/**
 * Created by DIT on 16/03/2017.
 */

public class Article implements Serializable {
    private String imageUrl;
    private String nom ;

    public Article(String imageUrl, String nom) {
        this.imageUrl = imageUrl;
        this.nom = nom;
    }

    public Article() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Article{" +
                "imageUrl='" + imageUrl + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
