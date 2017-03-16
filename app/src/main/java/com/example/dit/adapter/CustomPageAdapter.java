package com.example.dit.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.DataObject;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPageAdapter extends PagerAdapter {
    private Context context;
    private List<DataObject> dataObjectList;
    private LayoutInflater layoutInflater;
    int count = 0;

    //constructeur
    public CustomPageAdapter(Context context, List<DataObject> dataObjectList){

        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }
    @Override
    public int getCount() {
        return dataObjectList.size();
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
        ImageView image1 = (ImageView)view.findViewById(R.id.image1);
        ImageView image2 = (ImageView)view.findViewById(R.id.image2);
        ImageView image3 = (ImageView)view.findViewById(R.id.image3);
        ImageView image4 = (ImageView)view.findViewById(R.id.image4);
        ImageView image5 = (ImageView)view.findViewById(R.id.image5);
        //"https://s7g8.scene7.com/is/image/FLY//pictos-plus?fmt=png-alpha"



       /* Picasso.with(context).load(this.dataObjectList.get(position).getImage1Url()).into(image1);
        Picasso.with(context).load(this.dataObjectList.get(position).getImage2Url()).into(image2);
        Picasso.with(context).load(this.dataObjectList.get(position).getImage3Url()).into(image3);
        Picasso.with(context).load(this.dataObjectList.get(position).getImage4Url()).into(image4);
        Picasso.with(context).load(this.dataObjectList.get(position).getImage5Url()).into(image5);
       */
        LinearLayout ll = (LinearLayout)view.findViewById(R.id.layout_pictures);
        for(int i=0;i<this.dataObjectList.get(position).getListImagePicUrl().length;i++)
        {
            ImageView ii= new ImageView(context);
            Picasso.with(context).load(this.dataObjectList.get(position).getElement(this.dataObjectList.get(position).getListImagePicUrl(),i)).into(ii);
            ll.addView(ii);
        }
        textNom.setText(this.dataObjectList.get(position).getNom());

        Picasso.with(context).load(this.dataObjectList.get(position).getImageBackgroundUrl()).into(imageBackground);
        if(dataObjectList.get(position).getFabFUrl() == true) {
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





//Picasso.with(context).load(dataObjectList.get(position).getImageUrl()).placeholder(R.drawable.img1).centerCrop().fit().into(displayImage); picasso with placeHolder
//displayImage.setImageResource(this.dataObjectList.get(position).getImageUrl());
//displayImage.setImageDrawable(this.dataObjectList.get(position).getImageView());
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
