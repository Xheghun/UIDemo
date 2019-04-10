package com.xheghun.uidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryAdapater extends RecyclerView.Adapter<GalleryAdapater.GalleryItemViewHolder> {

    private Context context;
    List<GalleryItem> items;

    public GalleryAdapater(Context context, List<GalleryItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_item,parent,false);
        return new GalleryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GalleryItemViewHolder holder, int position) {

        if (items != null) {
            GalleryItem recipe = items.get(position);
            holder.name.setText(recipe.getName());
            holder.artist.setText(recipe.getArtist());
            Glide.with(context).load(recipe.getImg()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class GalleryItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, artist;
        AppCompatToggleButton star;

        public GalleryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.album_cover);
            name = itemView.findViewById(R.id.name);
            artist = itemView.findViewById(R.id.artist);
            star = itemView.findViewById(R.id.toggle_btn);
        }
    }
}
