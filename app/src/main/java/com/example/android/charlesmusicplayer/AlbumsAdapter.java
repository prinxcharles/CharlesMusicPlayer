package com.example.android.charlesmusicplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.charlesmusicplayer.R;
import com.example.android.charlesmusicplayer.TrackInfo;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<com.example.android.charlesmusicplayer.AlbumsAdapter.MyViewHolder> {

    private List<TrackInfo> albumList;

    AlbumsAdapter(List<TrackInfo> albumList) {
        this.albumList = albumList;
    }

    @Override
    public void onBindViewHolder(@NonNull final com.example.android.charlesmusicplayer.AlbumsAdapter.MyViewHolder holder, int position) {
        TrackInfo album = albumList.get(position);
        holder.title.setText(album.getHeadText());
        holder.count.setText(album.getDescText());
        holder.thumbnail.setImageResource(album.getImage());
    }

    @NonNull
    @Override
    public com.example.android.charlesmusicplayer.AlbumsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);

        return new com.example.android.charlesmusicplayer.AlbumsAdapter.MyViewHolder(itemView);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView count;
        public ImageView thumbnail;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.album_title);
            count = view.findViewById(R.id.artist);
            thumbnail = view.findViewById(R.id.album_art);
        }
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
