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

import com.squareup.picasso.Picasso;

import java.util.List;

public class InstaFeedAdapter extends RecyclerView.Adapter<InstaFeedAdapter.ViewHolder> {

    List<InstaFeedModel> modelList;

    public InstaFeedAdapter(List<InstaFeedModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public InstaFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_feed,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstaFeedAdapter.ViewHolder holder, int position) {
        InstaFeedModel model = modelList.get(position);

        int image = model.getImage();
        String username = model.getUsername();
        String location = model.getLocation();
        String feed_img = model.getFeed_img();
        String status = model.getStatus();
        String comment_count = model.getComment_count();
        String date = model.getDate();

        holder.setItems(image, username, location, feed_img, status, comment_count, date);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userProfile, userProfile1, imageView;
        TextView username_id, location_id, status_id, comment_count_id, date_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userProfile = itemView.findViewById(R.id.userProfile_id);
            userProfile1 = itemView.findViewById(R.id.userProfile1_id);
            imageView = itemView.findViewById(R.id.imageView);
            username_id = itemView.findViewById(R.id.userName_id);
            location_id = itemView.findViewById(R.id.location_id);
            status_id = itemView.findViewById(R.id.status_id);
            comment_count_id = itemView.findViewById(R.id.comment_count_id);
            date_id = itemView.findViewById(R.id.date_id);

        }

        public void setItems(int image, String username, String location, String feed_img, String status, String comment_count, String date) {
            Bitmap myLogo = BitmapFactory.decodeResource(itemView.getContext().getResources(), image);
            userProfile.setImageBitmap(myLogo);
            userProfile1.setImageBitmap(myLogo);

            Picasso.get().load(feed_img).into(imageView);

            username_id.setText(username.trim());
            location_id.setText(location.trim());
            status_id.setText(status.trim());
            date_id.setText(date.trim());
            comment_count_id.setText("View all " + comment_count.trim() +" Comments");
        }
    }
}
