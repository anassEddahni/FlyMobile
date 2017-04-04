package com.example.dit.adapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    int row_index = 0;

    public HorizontalAdapter(List<String> horizontalList) {
        this.horizontalList = horizontalList;
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

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtView.setText(horizontalList.get(position));
        holder.itemLinearLayout.setBackgroundColor(Color.parseColor("#567845"));
        holder.txtView.setTextColor(Color.parseColor("#ffffff"));
        holder.itemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.itemLinearLayout.setBackgroundColor(Color.parseColor("#aa2e2e2e"));
            holder.txtView.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.itemLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.txtView.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }


}
