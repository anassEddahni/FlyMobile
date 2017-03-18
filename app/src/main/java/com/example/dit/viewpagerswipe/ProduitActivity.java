package com.example.dit.viewpagerswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dit.adapter.ExpandableListAdapter;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.DataObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProduitActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    private Categories monObjetCat;
    TextView nomProduit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        monObjetCat= (Categories) getIntent().getSerializableExtra("maClasseDataObject");
        //String string = monObjet.getCategories().get(0).getAttributList().get(0).getNom();
        Log.d("mon noom","=============="+monObjetCat.toString());


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        ImageView imageArticle = (ImageView) findViewById(R.id.image_article);
         nomProduit = (TextView) findViewById(R.id.nom_produit);
        TextView description = (TextView) findViewById(R.id.description_produit);
        TextView prixProduit = (TextView) findViewById(R.id.prix_produit);
        TextView prixEcoProduit = (TextView) findViewById(R.id.prix_eco_produit);

        nomProduit.setText(monObjetCat.getProduit().getNom());
        Log.d("STRIIIIIING","================"+monObjetCat.getProduit().getNom());
        description.setText(monObjetCat.getProduit().getDesc());
        prixProduit.setText(monObjetCat.getProduit().getPrix());
        prixEcoProduit.setText(monObjetCat.getProduit().getPrixEco());


        Picasso.with(this).load(monObjetCat.getPhotoUrl()).into(imageArticle);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        /*// Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
*/
    }

    /*
	 * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();

        // Adding child data
        listDataHeader.add(monObjetCat.getAttributList().get(0).getNom());
        listDataHeader.add(monObjetCat.getAttributList().get(1).getNom());
        listDataHeader.add(monObjetCat.getAttributList().get(2).getNom());
        listDataHeader.add(monObjetCat.getAttributList().get(3).getNom());
        //listDataHeader.add("CONFORT");

        // Adding child data
        List<Article> matiere = new ArrayList<>();
        matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(0));
        matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(1));



        List<Article> couleur = new ArrayList<>();
        couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(0));
        couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(1));


        List<Article> accoudoir = new ArrayList<>();
        accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(0));
        accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(1));

        List<Article> confort = new ArrayList<>();
        confort.add(monObjetCat.getAttributList().get(3).getArticles().get(0));
        confort.add(monObjetCat.getAttributList().get(3).getArticles().get(1));


        listDataChild.put(listDataHeader.get(0), matiere); // Header, Child data


       listDataChild.put(listDataHeader.get(1), couleur);
        listDataChild.put(listDataHeader.get(2), accoudoir);
        listDataChild.put(listDataHeader.get(3), confort);

    }

}
