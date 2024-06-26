package com.example.constraintlayoutui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private static int ADD_STORY_TYPE=0;
    private static int ALL_STORY_TYPE=1;
    List<StoryModel> modelList;

    public StoryAdapter(List<StoryModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == ADD_STORY_TYPE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item_add, parent, false);
        } else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        StoryModel model = modelList.get(position);

        int viewType = getItemViewType(position);
        if(viewType == ADD_STORY_TYPE){
            String uid = model.getUid();
            int image = model.getImage();
            holder.setAddStroy(uid,image);
        } else {
            String uid = model.getUid();
            String sid = model.getSid();
            String name = model.getName();
            int image = model.getImage();
            holder.setStory(uid, sid, name, image);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) return 0;
        else return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView profile_img;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_id);
            profile_img = itemView.findViewById(R.id.userProfile_id);
        }

        public void setAddStroy(String uid, int image) {
            title.setText("Add Story");
            Bitmap myLogo = BitmapFactory.decodeResource(itemView.getContext().getResources(), image);
            profile_img.setImageBitmap(myLogo);
        }

        public void setStory(String uid, String sid, String name, int image) {
            title.setText(name);
            Bitmap myLogo = BitmapFactory.decodeResource(itemView.getContext().getResources(), image);
            profile_img.setImageBitmap(myLogo);
        }
    }
}
