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
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class CategoriesActivity extends AppCompatActivity {

    private int positionItem = 0;
    private Categories oneCategorie;
    private Programme monProgramme;
    private ViewPager viewPagerArticle;
    private Programme oneProgramme;
    private List<Categories> listCategories ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        viewPagerArticle = (ViewPager) findViewById(R.id.viewpager_article);
        ImageView logoFly = (ImageView) findViewById(R.id.logo_fly);
        monProgramme = (Programme) getIntent().getSerializableExtra("maClasseProgramme");
        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);
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
