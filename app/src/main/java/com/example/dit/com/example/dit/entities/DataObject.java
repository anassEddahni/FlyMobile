package com.example.dit.com.example.dit.entities;

import com.example.dit.com.example.dit.entities.Categories;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DIT on 14/03/2017.
 */

public class DataObject implements Serializable {
    private String nom ;
    private String imageBackgroundUrl;
    private String[] listImagePicUrl;
    private Boolean fabFUrl;
    private List<Categories> categories;

    public DataObject(String imageBackgroundUrl, String[] listImagePicUrl,String nom, Boolean fabFUrl) {
        this.nom = nom;
        this.imageBackgroundUrl = imageBackgroundUrl;
        this.listImagePicUrl = listImagePicUrl;
        this.fabFUrl = fabFUrl;
    }

    public DataObject(String imageBackgroundUrl, String[] listImagePicUrl,String nom, Boolean fabFUrl,List<Categories> categories) {
        this.nom = nom;
        this.imageBackgroundUrl = imageBackgroundUrl;
        this.listImagePicUrl = listImagePicUrl;
        this.fabFUrl = fabFUrl;
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categoriesList) {
        this.categories = categoriesList;
    }

    public DataObject() {

    }


    public String getImageBackgroundUrl() {
        return imageBackgroundUrl;
    }

    public void setImageBackgroundUrl(String imageBackgroundUrl) {
        this.imageBackgroundUrl = imageBackgroundUrl;
    }

    public String[] getListImagePicUrl() {
        return listImagePicUrl;
    }

    public void setListImagePicUrl(String[] listImagePicUrl) {
        this.listImagePicUrl = listImagePicUrl;
    }

    public Boolean getFabFUrl() {
        return fabFUrl;
    }

    public void setFabFUrl(Boolean fabFUrl) {
        this.fabFUrl = fabFUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }




    public String getCatElement(String[] listImagePicUrl, int index ){
        return listImagePicUrl[index];
    }

    public String getElement(String[] listImagePicUrl, int index ){
        return listImagePicUrl[index];
    }


    @Override
    public String toString() {
        return "DataObject{" +
                "nom='" + nom + '\'' +
                ", imageBackgroundUrl='" + imageBackgroundUrl + '\'' +
                ", listImagePicUrl=" + Arrays.toString(listImagePicUrl) +
                ", fabFUrl=" + fabFUrl +
                ", categoriesList=" + categories +
                '}';
    }
}
