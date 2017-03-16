package com.example.dit.viewpagerswipe;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DIT on 14/03/2017.
 */

public class DataObject implements Serializable {
    private String nom ;
    private String imageBackgroundUrl;
    private String[] listImagePicUrl;
    private Boolean fabFUrl;
    List<Categories> categories;


    public DataObject(String imageBackgroundUrl, String[] listImagePicUrl,String nom, Boolean fabFUrl) {
        this.nom = nom;
        this.imageBackgroundUrl = imageBackgroundUrl;
        this.listImagePicUrl = listImagePicUrl;
        this.fabFUrl = fabFUrl;
    }

    public DataObject(String imageBackgroundUrl, String[] listImagePicUrl,String nom, Boolean fabFUrl, List<Categories> categories) {
        this.nom = nom;
        this.imageBackgroundUrl = imageBackgroundUrl;
        this.listImagePicUrl = listImagePicUrl;
        this.fabFUrl = fabFUrl;
        this.categories = categories;
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


    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public String getCatElement(String[] listImagePicUrl, int index ){
        return listImagePicUrl[index];
    }



    public String getElement(String[] listImagePicUrl, int index ){
        return listImagePicUrl[index];
    }


}




    /*private String image1Url;
    private String image2Url;
    private String image3Url;
    private String image4Url;
    private String image5Url;*/


    /*public DataObject(String imageBackgroundUrl, String image1Url, String image2Url, String image3Url, String image4Url, String image5Url, String fabFUrl) {
        this.imageBackgroundUrl = imageBackgroundUrl;
        this.image1Url = image1Url;
        this.image2Url = image2Url;
        this.image3Url = image3Url;
        this.image4Url = image4Url;
        this.image5Url = image5Url;
        this.fabFUrl = fabFUrl;
    }
    /*
    public String getImage1Url() {
        return image1Url;
    }

    public void setImage1Url(String image1Url) {
        this.image1Url = image1Url;
    }

    public String getImage2Url() {
        return image2Url;
    }

    public void setImage2Url(String image2Url) {
        this.image2Url = image2Url;
    }

    public String getImage3Url() {
        return image3Url;
    }

    public void setImage3Url(String image3Url) {
        this.image3Url = image3Url;
    }

    public String getImage4Url() {
        return image4Url;
    }

    public void setImage4Url(String image4Url) {
        this.image4Url = image4Url;
    }

    public String getImage5Url() {
        return image5Url;
    }

    public void setImage5Url(String image5Url) {
        this.image5Url = image5Url;
    }*/







  /*public DataObject(String imageUrl, String imageName) {
        this.imageUrl = imageUrl;
        this.imageName = imageName;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
*/