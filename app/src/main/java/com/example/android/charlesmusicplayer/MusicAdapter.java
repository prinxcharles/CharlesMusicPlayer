package com.example.android.charlesmusicplayer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

    public class MusicAdapter extends ArrayAdapter <TrackInfo>{
        public MusicAdapter(Context context, ArrayList<TrackInfo> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View  listView = convertView;
            // Get the data item for this position
            TrackInfo user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (listView == null) {
                listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            // Lookup view for data population
            ImageView albumArt = (ImageView) listView.findViewById(R.id.track_image);
            TextView head = (TextView) listView.findViewById(R.id.track_title);
            TextView desc = (TextView) listView.findViewById(R.id.artist);
            // Populate the data into the template view using the data object
            albumArt    .setImageResource(user.imageResource);
            head.setText(user.heading);
            desc.setText(user.description);
            // Return the completed view to render on screen

            return listView;

        }
    }


