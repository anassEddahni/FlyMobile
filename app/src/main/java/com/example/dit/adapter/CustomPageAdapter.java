package com.example.dit.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPageAdapter extends PagerAdapter {
    private Context context;
    private List<Programme> programmeList;
    private LayoutInflater layoutInflater;
    int count = 0;

    //constructeur
    public CustomPageAdapter(Context context, List<Programme> programmeList){

        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.programmeList = programmeList;
    }
    @Override
    public int getCount() {
        return programmeList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = this.layoutInflater.inflate(R.layout.pager_list_items, container, false);

        ImageView fabF = (ImageView)view.findViewById(R.id.fabrication_francaise);
        ImageView imageBackground = (ImageView)view.findViewById(R.id.image_background);
        TextView textNom = (TextView) view.findViewById(R.id.nom_titre);
        TextView fabricFr = (TextView) view.findViewById(R.id.text_fabrication_fracaise);
        LinearLayout ll = (LinearLayout)view.findViewById(R.id.layout_pictures);

        for(int i = 0; i<this.programmeList.get(position).getListImagePicUrl().length; i++)
        {
            ImageView ii= new ImageView(context);
            Picasso.with(context).load(this.programmeList.get(position).getElement(this.programmeList.get(position).getListImagePicUrl(),i)).into(ii);
            ll.addView(ii);
        }

        textNom.setText(this.programmeList.get(position).getNom());
        Picasso.with(context).load(this.programmeList.get(position).getImageBackgroundUrl()).into(imageBackground);

        if(programmeList.get(position).getFabFUrl() == true) {
            Picasso.with(context).load("https://s7g8.scene7.com/is/image/FLY//pictos-plus?fmt=png-alpha").into(fabF);
        }else {
            fabricFr.setText("");
        }

        container.addView(view);
        return view;
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
