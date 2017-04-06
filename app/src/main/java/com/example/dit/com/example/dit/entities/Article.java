package com.example.dit.com.example.dit.entities;

import java.io.Serializable;

/**
 * Created by DIT on 16/03/2017.
 */

public class Article implements Serializable {
    private String imageUrl;
    private String nom ;
    private boolean checked = false ;

    public Article(String imageUrl, String nom) {
        this.imageUrl = imageUrl;
        this.nom = nom;
    }

    public Article() {

    }

    public Article(String imageUrl, String nom, boolean checked) {
        this.imageUrl = imageUrl;
        this.nom = nom;
        this.checked = checked;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Article{" +
                "imageUrl='" + imageUrl + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
