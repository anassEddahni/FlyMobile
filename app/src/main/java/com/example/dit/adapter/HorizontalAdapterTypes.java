package com.example.dit.adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.viewpagerswipe.R;

import java.util.List;

/**
 * Created by DIT on 30/03/2017.
 */

public class HorizontalAdapterTypes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Article> horizontalListChild;
    Context context;
    public HorizontalAdapterTypes(List<Article> horizontalListChild, Context context) {
        this.horizontalListChild = horizontalListChild;
        this.context = context;
    }

     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtView;
         public LinearLayout itemLinearLayout;
        public MyViewHolder(View view) {
            super(view);
            txtView = (TextView) view.findViewById(R.id.lblListItem);
            itemLinearLayout = (LinearLayout) view.findViewById(R.id.item_group);

        }

         @Override
         public void onClick(View v) {

         }
     }

    class MyViewHolderChild extends RecyclerView.ViewHolder {
        public TextView txtView;
        public ImageView imageChild;
        public MyViewHolderChild(View view) {
            super(view);
            txtView = (TextView) view.findViewById(R.id.lblListItem);
            imageChild = (ImageView) view.findViewById(R.id.image_child);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2*2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        switch (viewType){
            case 0: return new  MyViewHolder(itemView);
            case 2: return new MyViewHolderChild(itemView2);
        }


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                MyViewHolder MyViewHolder = (MyViewHolder)holder;
                break;

            case 2:
                MyViewHolderChild MyViewHolderChild = (MyViewHolderChild)holder;
                break;
        }

    }

   /* @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtView.setText(horizontalList.get(position));


    }*/

    @Override
    public int getItemCount() {
        return horizontalListChild.size();
    }


}
