package com.example.dit.adapter;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dit.viewpagerswipe.R;

import java.util.List;
/**
 * Created by DIT on 30/03/2017.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private SparseBooleanArray selectedItems;
    private List<String> horizontalList;

    public HorizontalAdapter(List<String> horizontalList) {
        this.horizontalList = horizontalList;
    }

     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtView;
        public MyViewHolder(View view) {
            super(view);
            txtView = (TextView) view.findViewById(R.id.lblListItem);
        }

         @Override
         public void onClick(View v) {

         }
     }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        holder.txtView.setText(horizontalList.get(position));
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }


}
