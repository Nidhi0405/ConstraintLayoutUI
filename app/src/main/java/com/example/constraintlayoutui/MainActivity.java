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

    InstaFeedAdapter feedAdapter;
    List<InstaFeedModel> feedModelList = new ArrayList<>();

    RecyclerView recyclerView, feedRecyclerView;

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

        //insta feed
        feedRecyclerView = findViewById(R.id.feed_recyclerView_id);

        feedModelList.add(new InstaFeedModel(R.drawable.user_profile,"Jack", "USA", "https://www.plannthat.com/wp-content/uploads/2017/10/brahmino.png", "Hello, have a nice day","3", "10/7/2023"));
        feedModelList.add(new InstaFeedModel(R.drawable.user_profile,"Alina","USA","https://i0.wp.com/thehhub.com/wp-content/uploads/2018/10/Photo-Nov-13-5-56-21-PM.jpg?resize=1440%2C961", "Hello, have a nice day","8", "18/7/2023"));
        feedModelList.add(new InstaFeedModel(R.drawable.user_profile,"Mariya","USA","https://i0.wp.com/digital-photography-school.com/wp-content/uploads/2015/05/promote-your-photography-on-Instagram-1006.jpg?fit=717%2C717&ssl=1", "Hello, have a nice day","13", "1/7/2023"));
        feedModelList.add(new InstaFeedModel(R.drawable.user_profile,"Jack","USA","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaYFjYA4n9jA30XMr0YMswgufCFTDoGO2-f0r1gZakb6badmzDJngUab4bCLGFCGTBAnU&usqp=CAU", "Hello, have a nice day","4", "11/7/2023"));
        feedModelList.add(new InstaFeedModel(R.drawable.user_profile,"Alina","USA","https://i0.wp.com/digital-photography-school.com/wp-content/uploads/2015/05/promote-your-photography-on-Instagram-1006.jpg?fit=717%2C717&ssl=1", "Hello, have a nice day","17", "17/7/2023"));

        feedAdapter = new InstaFeedAdapter(feedModelList);
        feedRecyclerView.setAdapter(feedAdapter);
        feedAdapter.notifyDataSetChanged();
    }
}