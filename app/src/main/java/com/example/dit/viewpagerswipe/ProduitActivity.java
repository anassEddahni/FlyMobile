package com.example.dit.viewpagerswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dit.adapter.ExpandableListAdapter;
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
    HashMap<String, List<String>> listDataChild;
    private Categories monObjetCat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        monObjetCat= (Categories) getIntent().getSerializableExtra("maClasseDataObject");
        //String string = monObjet.getCategories().get(0).getAttributList().get(0).getNom();
        Log.d("mon noom","=============="+monObjetCat.toString());


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        ImageView imageView = (ImageView) findViewById(R.id.photo_article);
        //Picasso.with(this).load(monObjetCat.getPhotoUrl()).into(imageView);
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
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(monObjetCat.getAttributList().get(0).getNom());
        listDataHeader.add("COULEUR");
        listDataHeader.add("ACCOUDOIRS ET PIEDS");
        //listDataHeader.add("CONFORT");

        // Adding child data
        List<String> matiere = new ArrayList<String>();
        matiere.add("Cuir");
        matiere.add("microfibre");
        matiere.add("tissu luxury");
        /*matiere.add("Pulp Fiction");
        matiere.add("The Good, the Bad and the Ugly");
        matiere.add("The Dark Knight");
        matiere.add("12 Angry Men");
*/
        List<String> couleur = new ArrayList<String>();
        couleur.add("Noir");
        couleur.add("Blanc");
        /*nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");*/

        List<String> accoudoir = new ArrayList<String>();
        accoudoir.add("acoudoirs et pieds eban alu brossé");
        /*accoudoir.add("The Spectacular Now");
        accoudoir.add("The Canyons");
        accoudoir.add("Europa Report");*/

        List<String> confort = new ArrayList<String>();
        accoudoir.add("design");


        listDataChild.put(listDataHeader.get(0), matiere); // Header, Child data
        listDataChild.put(listDataHeader.get(1), couleur);
        listDataChild.put(listDataHeader.get(2), accoudoir);
        //listDataChild.put(listDataHeader.get(3), confort);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }

}
