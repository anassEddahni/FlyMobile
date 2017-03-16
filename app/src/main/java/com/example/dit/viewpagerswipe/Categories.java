package com.example.dit.viewpagerswipe;

import java.io.Serializable;

/**
 * Created by DIT on 15/03/2017.
 */

public class Categories implements Serializable{
    String photoUrl;
    String name;
    String montant;

    public Categories(String photoUrl, String name, String montant) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.montant = montant;
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
}
