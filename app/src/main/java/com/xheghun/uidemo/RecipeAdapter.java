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
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    Context context;
    List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(context).inflate(R.layout.recipe_item,parent,false);
        return new RecipeViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        if (recipes != null) {
            Recipe recipe = recipes.get(position);

            holder.title.setText(recipe.getTitle());
            holder.time.setText(recipe.getTime());
            Glide.with(context).load(recipe.getImg()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
       return recipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        ImageView img;
        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.card_title);
            time = itemView.findViewById(R.id.card_time);
            img = itemView.findViewById(R.id.card_img);
        }
    }
}
