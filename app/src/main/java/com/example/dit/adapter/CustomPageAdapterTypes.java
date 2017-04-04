package com.example.dit.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPageAdapterTypes extends PagerAdapter {
    private Context context;
    private Programme monObjetProg;
    private LayoutInflater layoutInflater;
    int count = 0;

    //constructeur
    public CustomPageAdapterTypes(Context context,Programme monObjetProg){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.monObjetProg = monObjetProg;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if(position == 0){
            View view1 = this.layoutInflater.inflate(R.layout.more_details_0, container, false);
            TextView nomProduit = (TextView) view1.findViewById(R.id.nom_produit);
            TextView description = (TextView) view1.findViewById(R.id.description_produit);
            TextView prixProduit = (TextView) view1.findViewById(R.id.prix_produit);
            TextView prixEcoProduit = (TextView) view1.findViewById(R.id.prix_eco_produit);
            nomProduit.setText(monObjetProg.getCategories().get(0).getProduit().getNom());
            description.setText(monObjetProg.getCategories().get(0).getProduit().getDesc());
            prixProduit.setText(monObjetProg.getCategories().get(0).getProduit().getPrix());
            prixEcoProduit.setText(monObjetProg.getCategories().get(0).getProduit().getPrixEco());
            Spinner spinner = (Spinner) view1.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.nombre_article_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            container.addView(view1);
            return view1;

        }else{
            View view = this.layoutInflater.inflate(R.layout.more_details, container, false);
            container.addView(view);
            return view;
        }
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}





//Picasso.with(context).load(programmeList.get(position).getImageUrl()).placeholder(R.drawable.img1).centerCrop().fit().into(displayImage); picasso with placeHolder
//displayImage.setImageResource(this.programmeList.get(position).getImageUrl());
//displayImage.setImageDrawable(this.programmeList.get(position).getImageView());
//ImageView displayImage = (ImageView)view.findViewById(R.id.large_image);
//TextView imageText = (TextView)view.findViewById(R.id.image_name);
 /*MyHolder holder;
        //recuperer les view a partir de pager_list_item
        if(view == null){
            holder = new MyHolder(view);
            view.setTag(holder);
            Log.d("iteration","count" +count++);
        }else{
            holder = (MyHolder) view.getTag();
        }
*/

/*
class MyHolder{
    ImageView fabF ;
    ImageView imageBackground ;
    ImageView image1 ;
    ImageView image2 ;
    ImageView image3 ;
    ImageView image4 ;
    ImageView image5 ;
    MyHolder(View view){
        fabF = (ImageView)view.findViewById(R.id.fabrication_francaise);
        imageBackground = (ImageView)view.findViewById(R.id.image_background);
        image1 = (ImageView)view.findViewById(R.id.image1);
        image2 = (ImageView)view.findViewById(R.id.image2);
        image3 = (ImageView)view.findViewById(R.id.image3);
        image4 = (ImageView)view.findViewById(R.id.image4);
        image5 = (ImageView)view.findViewById(R.id.image5);
    }
}
*/
