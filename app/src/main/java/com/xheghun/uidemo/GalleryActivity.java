package com.xheghun.uidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    List<GalleryItem> items;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        recyclerView = findViewById(R.id.gallery_rc);
        layoutManager = new GridLayoutManager(this,2);

        String titles[] = getResources().getStringArray(R.array.titles);
        String time[] = getResources().getStringArray(R.array.time);

        int images[] = {R.drawable.fps_1,R.drawable.fps2,R.drawable.forza,R.drawable.gran,
                R.drawable.fifa_m,R.drawable.ms,R.drawable.madden,R.drawable.fps2};

        int i;
        items =  new ArrayList<>();
        for (i = 0; i < titles.length; i++) {
            GalleryItem item = new GalleryItem();
            item.setName(titles[i]);
            item.setArtist(time[i]);
            item.setImg(images[i]);

            items.add(item);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new GalleryAdapater(this, items));
    }
}
