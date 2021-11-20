package com.example.hdrecord.rvs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hdrecord.R;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videoList;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videoList.get(position);
        if (video != null) {
            return;
        }

        holder.imgVideo.setImageResource(video.getResourceid());
        holder.nameVideo.setText(video.getName());
    }

    @Override
    public int getItemCount() {
        if (videoList != null) {
            return videoList.size();
        }
        return 0;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgVideo;
        private TextView nameVideo;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgVideo = itemView.findViewById(R.id.image_video_item);
            nameVideo = itemView.findViewById(R.id.name_video_item);
        }
    }
}
