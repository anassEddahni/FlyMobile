package com.example.dit.viewpagerswipe;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dit.adapter.CustomArticleAdapter;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.DataObject;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    private int positionItem = 0;
    private Categories oneArticle;
    private DataObject monObjet;
    private ViewPager viewPagerArticle;
    private List<Categories> listCategories ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        viewPagerArticle = (ViewPager) findViewById(R.id.viewpager_article);
        ImageView logoFly = (ImageView) findViewById(R.id.logo_fly);
        monObjet = (DataObject) getIntent().getSerializableExtra("maClasseDataObject");
        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);
        CustomArticleAdapter mCustomArticleAdapter = new CustomArticleAdapter(ArticleActivity.this, monObjet);
        viewPagerArticle.setAdapter(mCustomArticleAdapter);
        viewPagerArticle.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //int currentposition;
            @Override
            public void onPageSelected(int pos) {
                positionItem = pos;
                Log.e("Current Postion", "" + positionItem);

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public final int getCurrentPage() {
                return positionItem;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void choisirCategorie(View view){

        oneArticle=new Categories();
        oneArticle=monObjet.getCategories().get(positionItem);
        Intent myIntent = new Intent(this,ProduitActivity.class);
        myIntent.putExtra("maClasseDataObject", (Serializable) oneArticle);
        startActivity(myIntent);

        /*montantArticle.setText(monObjet.getCategories().get(1).getMontant());
        nomArticle.setText(monObjet.getCategories().get(1).getName());
        Picasso.with(this).load(monObjet.getCategories().get(1).getPhotoUrl()).into(photoArticle);*/


    }
}
