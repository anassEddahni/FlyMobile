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

import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

/**
 * Created by DIT on 15/03/2017.
 */

public class CustomArticleAdapter extends PagerAdapter {
    private Context context;
    private Programme programme;
    private LayoutInflater layoutInflater;

    //constructeur
    public CustomArticleAdapter(Context context, Programme programme) {

        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.programme = programme;
    }

    @Override
    public int getCount() {
        return programme.getCategories().size();
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
        Log.d("catgories : ======"+position ,"  "+this.programme.toString());

        Picasso.with(context).load(this.programme.getCategories().get(position).getPhotoUrl()).into(photoArticle);
        nomArticle.setText(this.programme.getCategories().get(position).getName());
        montantArticle.setText(this.programme.getCategories().get(position).getMontant());

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}