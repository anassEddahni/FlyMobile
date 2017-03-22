package com.example.dit.viewpagerswipe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dit.adapter.ExpandableListAdapter;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.dit.viewpagerswipe.ConvertBitmap.getBytes;

public class ProduitActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    private Categories monObjetCat;
    TextView nomProduit ;
    ImageView imageProduit;
    Bitmap bmp;
    private int lastExpandedPosition = -1;
    ImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        imageProduit = (ImageView) findViewById(R.id.image_article);
        nomProduit = (TextView) findViewById(R.id.nom_produit);
        TextView description = (TextView) findViewById(R.id.description_produit);
        TextView prixProduit = (TextView) findViewById(R.id.prix_produit);
        TextView prixEcoProduit = (TextView) findViewById(R.id.prix_eco_produit);
        header = (ImageView) findViewById(R.id.image_header);

        //get categories object
        monObjetCat= (Categories) getIntent().getSerializableExtra("maClasseCategories");
        Picasso.with(this).load("http://media-cdn.fly.fr/media/rubriques/780-gauche-salons2016.jpg").resize(3100,600).into(header);
        nomProduit.setText(monObjetCat.getProduit().getNom());
        description.setText(monObjetCat.getProduit().getDesc());
        prixProduit.setText(monObjetCat.getProduit().getPrix());
        prixEcoProduit.setText(monObjetCat.getProduit().getPrixEco());
        //Picasso.with(this).load(monObjetCat.getPhotoUrl()).into(imageArticle);
        Picasso.with(this).load(monObjetCat.getProduit().getImageUrl()).into(imageProduit);

        // preparing list data
        prepareListData();
        //set data to expandable list
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting adapter to the list
        expListView.setAdapter(listAdapter);
        //collapse non-selected Group
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

    }

   //Préparation des données article
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();
        List<Article> matiere = new ArrayList<>();

        for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            listDataHeader.add(monObjetCat.getAttributList().get(i).getNom());
        }

       /* for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            for(int j = 0 ; j < monObjetCat.getAttributList().get(i).getArticles().size();j++){
                matiere.add(monObjetCat.getAttributList().get(i).getArticles().get(j));
            }
        }*/


        //ajouter les données aux fils
            //matuere
            matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(0));
            matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(1));

            //couleur
            List<Article> couleur = new ArrayList<>();
            couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(0));
            couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(1));

            //accoudoir
            List<Article> accoudoir = new ArrayList<>();
            accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(0));
            accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(1));

            //confort
            List<Article> confort = new ArrayList<>();
            confort.add(monObjetCat.getAttributList().get(3).getArticles().get(0));
            confort.add(monObjetCat.getAttributList().get(3).getArticles().get(1));

        //attribuer les données de fils à leurs headers
        listDataChild.put(listDataHeader.get(0), matiere); // Header, Child data
        listDataChild.put(listDataHeader.get(1), couleur);
        listDataChild.put(listDataHeader.get(2), accoudoir);
        listDataChild.put(listDataHeader.get(3), confort);

    }


    public void showFullScreen (View view){
        Intent intent = new Intent(this,FullScreenActivity.class);
        imageProduit.buildDrawingCache();
        bmp = imageProduit.getDrawingCache();
        byte [] mybyte ;
        mybyte =getBytes(bmp);
        intent.putExtra("Bitmap",mybyte);
        startActivity(intent);
    }
}
