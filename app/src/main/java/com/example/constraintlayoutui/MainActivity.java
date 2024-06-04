package com.example.constraintlayoutui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int ADD_STORY_TYPE=0;
    private static int ALL_STORY_TYPE=1;

    StoryAdapter adapter;
    List<StoryModel> modelList = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.story_recyclerView_id);

        modelList.add(new StoryModel(ADD_STORY_TYPE, "1", R.drawable.user_profile));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "2", "10", "Mariya", R.drawable.user_profile));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "3", "11", "Jack", R.drawable.user_profile));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "4", "12", "Alina", R.drawable.user_profile));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "5", "13", "Peter", R.drawable.user_profile));

        adapter = new StoryAdapter(modelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}