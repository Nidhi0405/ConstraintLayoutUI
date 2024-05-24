package com.example.constraintlayoutui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>{

    private List<Story> stories;
    private Context context;

    public StoriesAdapter(List<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }


    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_item,parent,false);
        StoriesViewHolder viewHolder = new StoriesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        //changing the background color if the story is seen
        if(stories.get(position).isSeen()){
            holder.storyOutline.setCardBackgroundColor(context.getResources().getColor(R.color.grey));
        }

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    //viewHolder
    public static class StoriesViewHolder extends RecyclerView.ViewHolder{
        private CardView storyOutline;
        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.findViewById(R.id.storyOutline);
        }
    }
}
