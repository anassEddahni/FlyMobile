package com.example.dit.com.example.dit.entities;

import java.io.Serializable;

/**
 * Created by DIT on 16/03/2017.
 */

public class Produit implements Serializable {
    private String nom;
    private String desc;
    private String prix;

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", desc='" + desc + '\'' +
                ", prix='" + prix + '\'' +
                ", prixEco='" + prixEco + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    private String prixEco;
    private String imageUrl;


    public Produit() {
    }

    public Produit(String nom, String desc, String prix, String prixEco, String imageUrl) {
        this.nom = nom;
        this.desc = desc;
        this.prix = prix;
        this.prixEco = prixEco;
        this.imageUrl = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPrixEco() {
        return prixEco;
    }

    public void setPrixEco(String prixEco) {
        this.prixEco = prixEco;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
