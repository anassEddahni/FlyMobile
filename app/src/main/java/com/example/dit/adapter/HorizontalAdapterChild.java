package com.example.dit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.refactor.library.SmoothCheckBox;

/**
 * Created by DIT on 31/03/2017.
 */

public class HorizontalAdapterChild extends RecyclerView.Adapter<HorizontalAdapterChild.MyViewHolderChild> {
    private List<Article> horizontalListChild;
    private Context context;
    private RecyclerItemClickListener recyclerItemClickListener;

    public HorizontalAdapterChild(List<Article> horizontalListChild, Context context, RecyclerItemClickListener recyclerItemClickListener) {
        this.horizontalListChild = horizontalListChild;
        this.context = context;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    public static class MyViewHolderChild extends RecyclerView.ViewHolder {
        public TextView txtView;
        public ImageView imageChild;
        public SmoothCheckBox scb;
        public RelativeLayout oneItemChild;
        public MyViewHolderChild(View view) {
            super(view);
            //txtView = (TextView) view.findViewById(R.id.lblListItem);
            imageChild = (ImageView) view.findViewById(R.id.image_child);
            scb = (SmoothCheckBox) view.findViewById(R.id.scb);
            oneItemChild = (RelativeLayout) view.findViewById(R.id.one_item_child);
        }
    }

    @Override
    public MyViewHolderChild onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolderChild(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolderChild holder, final int position) {
        Picasso.with(context).load(horizontalListChild.get(position).getImageUrl()).into(holder.imageChild);
        Article article = horizontalListChild.get(position);

        holder.scb.setChecked(article.isChecked());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerItemClickListener!= null){
                    recyclerItemClickListener.itemClicked(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return horizontalListChild.size();
    }


    public interface RecyclerItemClickListener{
        void itemClicked(int position);
    }

}
