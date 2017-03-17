package com.example.dit.com.example.dit.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DIT on 15/03/2017.
 */

public class Categories implements Serializable{
    private String photoUrl;
    private String name;
    private String montant;
    private Produit produit;
    private List<Attribut> attributList;

    public Categories(String photoUrl, String name, String montant, Produit produit, List<Attribut> attributList) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.montant = montant;
        this.produit = produit;
        this.attributList = attributList;
    }

    public Categories() {
    }

    public List<Attribut> getAttributList() {
        return attributList;
    }

    public void setAttributList(List<Attribut> attributList) {
        this.attributList = attributList;
    }




    public Categories(String photoUrl, String name, String montant) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.montant = montant;
    }

    public Categories(String photoUrl, String name, String montant, Produit produit) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.montant = montant;
        this.produit = produit;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "photoUrl='" + photoUrl + '\'' +
                ", name='" + name + '\'' +
                ", montant='" + montant + '\'' +
                ", produit=" + produit +
                ", attributList=" + attributList +
                '}';
    }
}
