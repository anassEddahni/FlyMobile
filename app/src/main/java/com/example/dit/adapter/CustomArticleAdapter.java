package com.example.dit.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.DataObject;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

/**
 * Created by DIT on 15/03/2017.
 */

public class CustomArticleAdapter extends PagerAdapter {
    private Context context;
    private DataObject dataObject;
    private LayoutInflater layoutInflater;

    //constructeur
    public CustomArticleAdapter(Context context, DataObject dataObject) {

        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObject = dataObject;
    }


    @Override
    public int getCount() {
        return dataObject.getCategories().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.article_list_items,container,false);
        ImageView photoArticle = (ImageView) view.findViewById(R.id.photo_article);
        TextView nomArticle = (TextView) view.findViewById(R.id.nom_article);
        //zoomAnimation
        Animation zoomAnimation = AnimationUtils.loadAnimation(context, R.anim.zoom);
        photoArticle.startAnimation(zoomAnimation);

        TextView montantArticle = (TextView) view.findViewById(R.id.montant_article);
        Log.d("catgories : ======"+position ,"  "+this.dataObject.toString());
        Log.d("catgories : ======","  =============================================");
        Picasso.with(context).load(this.dataObject.getCategories().get(position).getPhotoUrl()).into(photoArticle);
        nomArticle.setText(this.dataObject.getCategories().get(position).getName());
        montantArticle.setText(this.dataObject.getCategories().get(position).getMontant());

      //  Picasso.with(context).load(this.dataObjectList.get(position).getCategories().get(1).getPhotoUrl()).into(photoArticle);

        /*for(int j=0;j<this.dataObjectList.get(position).getCategories().size();j++) {
            Picasso.with(context).load(this.dataObjectList.get(position).getCategories().get(j).getPhotoUrl()).into(photoArticle);
        }*/






        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}