package com.example.hdrecord.rvs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hdrecord.R;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends Fragment {

    Context context;
    View view;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_video ,container, false);
        context = getContext();

        recyclerView = view.findViewById(R.id.rcv_video);
        videoAdapter = new VideoAdapter(getListVideo());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        videoAdapter = new VideoAdapter(getListVideo());
        recyclerView.setAdapter(videoAdapter);
        return view;
    }

    private List<Video> getListVideo() {
        List<Video> list = new ArrayList<>();
        list.add(new Video(R.mipmap.ic_launcher, "hoang", "address"));
        return list;
    }
}
