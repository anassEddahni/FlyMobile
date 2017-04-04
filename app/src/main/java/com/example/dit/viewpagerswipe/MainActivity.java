package com.example.dit.viewpagerswipe;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dit.adapter.CustomPageAdapter;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Attribut;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.Produit;
import com.example.dit.com.example.dit.entities.Programme;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    Programme oneArticle;
    List<Programme> getData;
    private ViewPager viewPager;
    private ImageView logoFly;
    String[] myListPicCanape ;
    String[] myListPicChaise;
    String[] myListPicTable;
    Button button;
    List<Categories> listCatChaise;
    List<Categories> listCatCanape;
    List<Categories> listCatTable;
    List<Attribut> listAttrCanape;
    List<Article> listArtCanapeMatiere;
    List<Article> listArtCanapeCouleur;
    List<Article> listArtCanapeAccoudoirs;
    List<Article> listArtCanapeConfort;
    Produit myproduit1;
    Produit myproduit2;
    Produit myproduit3;
    Produit myproduit4;
    Produit myproduit5;
    int positionItem = 0;
    TextView titlesStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.choisir);
        logoFly = (ImageView) findViewById(R.id.logo_fly);
        titlesStyle = (TextView) findViewById(R.id.titre1);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Sign_Painter_Gothic_JL.ttf");
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/SignPainterHouseScript.ttf");
        titlesStyle.setTypeface(font);

        Picasso.with(this).load("https://s7g8.scene7.com/is/image/FLY//logo-myfly?fmt=png-alpha").into(logoFly);

        myListPicCanape = new String[]{"https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha&wid=200&hei=200&scl=1.3", "https://s7g8.scene7.com/is/image/FLY//anglefixe?fmt=png-alpha&wid=170", "https://s7g8.scene7.com/is/image/FLY//angleconvertible?fmt=png-alpha&wid=170", "https://s7g8.scene7.com/is/image/FLY//convertible?fmt=png-alpha&wid=170", "https://s7g8.scene7.com/is/image/FLY//canape?fmt=png-alpha&wid=200"};
        myListPicChaise = new String[]{"https://s7g8.scene7.com/is/image/FLY//chaisetabouret?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//chaisehaute?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//tablebasse?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//tablerepas?fmt=png-alpha&wid=200"};
        myListPicTable = new String[]{"https://s7g8.scene7.com/is/image/FLY//1_50130_50138_1?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//1_50130_50141_1?fmt=png-alpha&wid=200", "https://s7g8.scene7.com/is/image/FLY//1_50130_50143_1?fmt=png-alpha&wid=200","https://s7g8.scene7.com/is/image/FLY//1_50137_50138_1?fmt=png-alpha&wid=200"};

        //recuperer les données
        List<Programme> getData = dataSource();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        //ViewPager Adapter
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(MainActivity.this, getData);
        viewPager.setAdapter(mCustomPagerAdapter);
        // SET indicator for view pager
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);


        //recuperer la position courante de viewPager
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {
                  positionItem =pos;
                Log.e("Current Postion", "" + positionItem);
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            public final int getCurrentPage(){
                return positionItem;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }});

        Log.d("le numero d'item","=========="+positionItem);

//REMPLIR LISTES PRODUITS
        myproduit1=new Produit("LINK","FAUTEUIL","439,90 $","dont 1,70 $ d'co part.","https://s7g8.scene7.com/is/image/FLY//4_A_77736205_77725384_77725478_0_0_77725475_77725590?wid=1486&hei=950&scl=0.7" );
        myproduit2=new Produit("LINK","Canapé fixe","489,90 € ","dont 4,50 € d'éco part.","https://s7g8.scene7.com/is/image/FLY//2_B_77736192_77725408_77735419_0_0_77735418_77725592?wid=1486&hei=950&scl=0.8" );
        myproduit3=new Produit("LINK","Canapé d'angle fixe","1 128,90 € ","dont 9,00 € d'éco part. ","https://s7g8.scene7.com/is/image/FLY//1_B_77736192_77725402_77725412_0_77725500_77725499_77725592?wid=2000&hei=950&scl=0.96" );
        myproduit4=new Produit("LINK","Canapé convertible","829,90 €","dont 5,50 € d'éco part. ","https://s7g8.scene7.com/is/image/FLY//3_B_77736221_77735505_77735650_0_0_77735649_77725592?wid=1486&hei=950&scl=0.8" );
        myproduit5=new Produit("LINK","Canapé d'angle ","1 738,90 € ","dont 10,00 € d'éco part. ","https://s7g8.scene7.com/is/image/FLY//5_B_77736221_77735509_77735540_0_77735646_77735645_77725592?wid=1486&hei=950&scl=0.99" );

//REMPLIR LISTE ARTICLE
        //liste fauteuil matiere
        listArtCanapeMatiere = new ArrayList<>();
        listArtCanapeMatiere.add(new Article("https://s7g8.scene7.com/is/image/FLY//D?wid=101&hei=91","cuir"));
        listArtCanapeMatiere.add(new Article("https://s7g8.scene7.com/is/image/FLY//A?wid=101&hei=91","microfibre"));
        //liste fauteuil couleur
        listArtCanapeCouleur = new ArrayList<>();
        listArtCanapeCouleur.add(new Article("https://s7g8.scene7.com/is/image/FLY//77725254?wid=101&hei=91","Chamois"));
        listArtCanapeCouleur.add(new Article("https://s7g8.scene7.com/is/image/FLY//77725256?wid=101&hei=91","Anthracite"));
        //liste accoudoirs/pieds
        listArtCanapeAccoudoirs = new ArrayList<>();
        listArtCanapeAccoudoirs.add(new Article("https://s7g8.scene7.com/is/image/FLY//77725492?wid=101&hei=91","Accoudoirs et pieds eban alu brossé "));
        listArtCanapeAccoudoirs.add(new Article("https://s7g8.scene7.com/is/image/FLY//77735412?wid=101&hei=91","Accoudoirs et pieds matis wengé"));
        //liste confort
        listArtCanapeConfort = new ArrayList<>();
        listArtCanapeConfort.add(new Article("https://s7g8.scene7.com/is/image/FLY//77725590?wid=101&hei=91","Design "));
        listArtCanapeConfort.add(new Article("https://s7g8.scene7.com/is/image/FLY//77725591?wid=101&hei=91","Ferme"));


//REMPLIR LISTES ATTRIBUTS
        listAttrCanape = new ArrayList<>();
        listAttrCanape.add(new Attribut("MATIERE",listArtCanapeMatiere));
        listAttrCanape.add(new Attribut("COULEUR",listArtCanapeCouleur));
        listAttrCanape.add(new Attribut("ACCOUDOIRS ET PIEDS",listArtCanapeAccoudoirs));
        listAttrCanape.add(new Attribut("CONFORT",listArtCanapeConfort));


//REMPLIR LISTE CATEGORIES

        //liste CANAPE
        listCatCanape =new ArrayList<>();
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//fauteuil?fmt=png-alpha&wid=300&hei=300&scl=0.9","Fauteuil","à partir de : 439,90 $",myproduit1,listAttrCanape));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//canape?fmt=png-alpha&wid=300&hei=300&scl=0.9","Canapé fixe","à partir de : 489,90 $",myproduit2,listAttrCanape));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//anglefixe?fmt=png-alpha&wid=500&hei=300&scl=0.9","Canapé d'angle fixe","à partir de : 1128,90 $",myproduit3,listAttrCanape));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//convertible?fmt=png-alpha&wid=400&hei=200&scl=0.9","Canapé convertible","à partir de : 829,90 $",myproduit4,listAttrCanape));
        listCatCanape.add(new Categories("https://s7g8.scene7.com/is/image/FLY//angleconvertible?fmt=png-alpha&wid=450&hei=200&scl=0.9","Canapé d'angle convertible","à partir de : 1738,90 $",myproduit5,listAttrCanape));
       //liste CHAISE
        listCatChaise = new ArrayList<>();
        listCatChaise.add(new Categories("https://s7g8.scene7.com/is/image/FLY//chaisetabouret?fmt=png-alpha","Chaises  & tabourets","à partir de : 68,90 $"));
        listCatChaise.add(new Categories("https://s7g8.scene7.com/is/image/FLY//chaisehaute?fmt=png-alpha","Chaises hautes","à partir de : 68,90 $"));
        listCatChaise.add(new Categories("https://s7g8.scene7.com/is/image/FLY//tablebasse?fmt=png-alpha","Tables basses","à partir de : 74,90 $"));
        listCatChaise.add(new Categories("https://s7g8.scene7.com/is/image/FLY//tablerepas?fmt=png-alpha","Tables repas","à partir de : 248,90 $"));
        //liste TABLE
        listCatTable = new ArrayList<>();
        listCatTable.add(new Categories("https://s7g8.scene7.com/is/image/FLY//1_50130_50138_1?fmt=png-alpha&wid=200","Ma Table VOLCANI","à partir de : 68,90 $"));
        listCatTable.add(new Categories("https://s7g8.scene7.com/is/image/FLY//1_50130_50141_1?fmt=png-alpha&wid=200","Ma Table VOLCANI","à partir de : 68,90 $"));
        listCatTable.add(new Categories("https://s7g8.scene7.com/is/image/FLY//1_50130_50143_1?fmt=png-alpha&wid=200","Ma Table VOLCANI","à partir de : 74,90 $"));
        listCatTable.add(new Categories("https://s7g8.scene7.com/is/image/FLY//1_50137_50138_1?fmt=png-alpha&wid=200","Ma Table VOLCANI","à partir de : 248,90 $"));

    }

    public void choisirArticle(View view){
        List<Programme> getData = dataSource();
        oneArticle=new Programme();
        oneArticle=getData.get(positionItem);
        Intent myIntent = new Intent(this,CategoriesActivity.class);
        myIntent.putExtra("maClasseProgramme", (Serializable) oneArticle);
        startActivity(myIntent);
    }

    public void choisirArticleswipe(View view){
        List<Programme> getData = dataSource();
        oneArticle=new Programme();
        oneArticle=getData.get(positionItem);
        Intent myIntent = new Intent(this,CategoriesActivity.class);
        myIntent.putExtra("maClasseProgramme", (Serializable) oneArticle);
        startActivity(myIntent);
    }

    //RESSOURCES
    private List<Programme> dataSource(){
        List<Programme> data = new ArrayList<Programme>();
        //canapé
        data.add(new Programme("https://s7g8.scene7.com/is/image/FLY//linkup?fmt=jpg&wid=781&hei=1068",myListPicCanape ,"MON CANAPé LINK",true,listCatCanape));
        //chaise
        data.add(new Programme("https://s7g8.scene7.com/is/image/FLY//sixteen?fmt=jpg&wid=781&hei=1068",myListPicChaise ,"MON Prgramme SIXTEEN",false,listCatChaise));
        //table
        data.add(new Programme("https://s7g8.scene7.com/is/image/FLY//volcani?fmt=jpg&wid=781&hei=1068",myListPicTable ,"Ma Table VOLCANI",false,listCatTable));
        return data;
    }
}

