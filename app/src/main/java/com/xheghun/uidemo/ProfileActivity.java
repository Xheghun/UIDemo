package com.xheghun.uidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {


    CircleImageView profile;
    ImageView profile_bg;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile_img);
        profile_bg = findViewById(R.id.bg);

        recyclerView = findViewById(R.id.recipe_rc);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        String titles[] = getResources().getStringArray(R.array.titles);
        String time[] = getResources().getStringArray(R.array.time);

        int images[] = {R.drawable.fps_1,R.drawable.fps2,R.drawable.forza,R.drawable.gran,
                R.drawable.fifa_m,R.drawable.ms,R.drawable.madden,R.drawable.fps2};

        int i;
        recipes =  new ArrayList<>();
        for (i = 0; i < titles.length; i++) {
            Recipe recipe = new Recipe();
            recipe.setTitle(titles[i]);
            recipe.setTime(time[i]);
            recipe.setImg(images[i]);

            recipes.add(recipe);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecipeAdapter(this, recipes));

        Glide.with(this).load(R.drawable.pp).into(profile);
        Glide.with(this).load(R.drawable.pbm).into(profile_bg);
    }
}
