package com.example.dit.viewpagerswipe;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.dit.adapter.CustomArticleAdapter;
import com.example.dit.com.example.dit.entities.DataObject;
import com.squareup.picasso.Picasso;

public class ArticleActivity extends AppCompatActivity {

    private DataObject monObjet;
    private ViewPager viewPagerArticle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        viewPagerArticle = (ViewPager) findViewById(R.id.viewpager_article);
        ImageView logoFly = (ImageView) findViewById(R.id.logo_fly);
        monObjet= (DataObject) getIntent().getSerializableExtra("maClasseDataObject");
        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);



        CustomArticleAdapter mCustomArticleAdapter = new CustomArticleAdapter(ArticleActivity.this,monObjet);
        viewPagerArticle.setAdapter(mCustomArticleAdapter);


        /*montantArticle.setText(monObjet.getCategories().get(1).getMontant());
        nomArticle.setText(monObjet.getCategories().get(1).getName());
        Picasso.with(this).load(monObjet.getCategories().get(1).getPhotoUrl()).into(photoArticle);*/


    }
}
