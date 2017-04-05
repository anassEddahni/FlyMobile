package com.example.dit.viewpagerswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dit.adapter.CustomArticleAdapter;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.Programme;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

import static com.example.dit.viewpagerswipe.R.id.viewpager_article;

public class CategoriesActivity extends AppCompatActivity {

     int positionItem = 0;
     Categories oneCategorie;
     Programme monProgramme;
     @BindView(viewpager_article) ViewPager viewPagerArticle;
     @BindView(R.id.logo_fly) ImageView logoFly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        monProgramme = (Programme) getIntent().getSerializableExtra("maClasseProgramme");
        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);
// set adapter viewpager
        CustomArticleAdapter mCustomArticleAdapter = new CustomArticleAdapter(CategoriesActivity.this, monProgramme);
        viewPagerArticle.setAdapter(mCustomArticleAdapter);
// SET indicator for view pager
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPagerArticle);

        viewPagerArticle.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        int itemPosition = positionItem;
        oneCategorie=new Categories();
        oneCategorie = monProgramme.getCategories().get(positionItem);
        Intent myIntent = new Intent(this,ProduitActivity.class);
        myIntent.putExtra("itemPosition",itemPosition);
        myIntent.putExtra("maClasseCategories", (Serializable) oneCategorie);
        myIntent.putExtra("maClasseProgramme", (Serializable) monProgramme);
        startActivity(myIntent);
    }
}
