package com.example.dit.viewpagerswipe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView logoFly;
    String[] myListPicCanape ;
    String[] myListPicChaise;
    String[] myListPicTable;
    Button button;
    List<Categories> listCatCanape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.choisir);

        logoFly = (ImageView) findViewById(R.id.logo_fly);
        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);
        myListPicCanape = new String[]{"https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//anglefixe?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//angleconvertible?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//convertible?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//canape?fmt=png-alpha&wid=200",};
        myListPicChaise = new String[]{"https://s7g8.scene7.com/is/image/FLY//chaisetabouret?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//chaisehaute?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//tablebasse?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//tablerepas?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//tablerepas?fmt=png-alpha&wid=200"};
        myListPicTable = new String[]{"https://s7g8.scene7.com/is/image/FLY//1_50130_50138_1?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//1_50130_50141_1?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//1_50130_50143_1?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//1_50137_50138_1?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//1_50137_50138_1?fmt=png-alpha&wid=200"};
        List<DataObject> getData = dataSource();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(MainActivity.this, getData);
        viewPager.setAdapter(mCustomPagerAdapter);

        listCatCanape =new ArrayList<>();
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha","Fauteuil","à partir de : 439,90 $"));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//canape?fmt=png-alpha","Canapé fixe","à partir de : 489,90 $"));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//anglefixe?fmt=png-alpha","Canapé d'angle fixe","à partir de : 1128,90 $"));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//convertible?fmt=png-alpha","Canapé convertible","à partir de : 829,90 $"));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//angleconvertible?fmt=png-alpha","Canapé d'angle convertible","à partir de : 1738,90 $"));

    }

    public void choisirArticle(View view){
        Intent myIntent = new Intent(this,ArticleActivity.class);
        //myIntent.putExtra("maClasse", (Serializable) new Categories("https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha","Fauteuil","à partir de : 439,90 $"));
        //myIntent.putExtra("maClasseDataObject", (Serializable) new DataObject("https://s7g8.scene7.com/is/image/FLY//linkup?fmt=jpg&wid=781&hei=1068",myListPicCanape ,"MON CANAPé LINK",true,listCatCanape));
        List<DataObject> getData = dataSource();
        myIntent.putExtra("maClasseDataObject", (Serializable) getData);
        startActivity(myIntent);
    }





    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();
        //canapé
        data.add(new DataObject("https://s7g8.scene7.com/is/image/FLY//linkup?fmt=jpg&wid=781&hei=1068",myListPicCanape ,"MON CANAPé LINK",true,listCatCanape));
        //chaise
        data.add(new DataObject("https://s7g8.scene7.com/is/image/FLY//sixteen?fmt=jpg&wid=781&hei=1068",myListPicChaise ,"MON Prgramme SIXTEEN",false,listCatCanape));

        //table
        data.add(new DataObject("https://s7g8.scene7.com/is/image/FLY//volcani?fmt=jpg&wid=781&hei=1068",myListPicTable ,"Ma Table VOLCANI",false,listCatCanape));


  //      data.add(new DataObject("https://s7g8.scene7.com/is/image/FLY//linkup?fmt=jpg&wid=781&hei=1068", "https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//anglefixe?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//angleconvertible?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//convertible?fmt=png-alpha&wid=200", "\"https://s7g8.scene7.com/is/image/FLY//canape?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//pictos-plus?fmt=png-alpha"));
        return data;
    }
}

