package com.example.qobel.organizator.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qobel.organizator.R;
import com.example.qobel.organizator.entity.OrganizationEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by qobel on 24.07.2017.
 */

public class OrganizationRecyclerAdapter extends RecyclerView.Adapter<OrganizationRecyclerAdapter.ViewHolder> {
    private static List<OrganizationEntity> organizationEntities;
    private static Context context;



    private static ClickListener clickListener;
    public OrganizationRecyclerAdapter(List<OrganizationEntity> organizationEntities,Context context) {
        this.organizationEntities = organizationEntities;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrganizationEntity   organizationEntity = organizationEntities.get(position);
         holder.title.setText(organizationEntity.getName());
        Picasso.with(this.context).load(organizationEntity.getImages().get(0)).into(holder.imageView);
         holder.description.setText(organizationEntity.getCity());
        holder.onClick(this);

    }

    @Override
    public int getItemCount() {
        return organizationEntities.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView title,description;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cardView = (CardView) itemView.findViewById(R.id.organizationCardView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView   = (ImageView) itemView.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View v) {
            clickListener.showItemBottomSheets(organizationEntities.get(getAdapterPosition()));
        }


        public void onClick(OrganizationRecyclerAdapter organizationRecyclerAdapter) {
            System.out.println(organizationRecyclerAdapter);
        }
    }
    public ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface ClickListener{
        public void showItemBottomSheets(OrganizationEntity organizationEntity);
    }
}
