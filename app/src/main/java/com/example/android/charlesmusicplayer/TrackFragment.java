package com.example.android.charlesmusicplayer;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.charlesmusicplayer.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends Fragment {

    public TrackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] TrackTitle = new String[]{
                getContext().getString(R.string.pain_killer), getContext().getString(R.string.when_you_kiss_me), getContext().getString(R.string.despacito),
                getContext().getString(R.string.all_over), getContext().getString(R.string.nwa_baby), getContext().getString(R.string.im_the_one),
                getContext().getString(R.string.in_my_feelings), getContext().getString(R.string.farewell), getContext().getString(R.string.house_on_fire),
                getContext().getString(R.string.try_sleeping_with_a_broken_heart)
        };


        int[] AlbumArt = new int[]{
                R.drawable.sakordie_ft_runtown, R.drawable.shana_twain, R.drawable.despacito, R.drawable.tiwa_savage_all_over, R.drawable.davido_nwa_baby,
                R.drawable.dj_khaled_im_the_one_track_art, R.drawable.drake_in_my_feelings, R.drawable.jcole_farewell_album_art, R.drawable.sia_house_on_fire_track_art,
                R.drawable.alicia_keys_try_sleeping_with_a_broken_heart_track_art
        };

        String[] Artist = new String[]{
                getContext().getString(R.string.sarkodie_ft_runtown), getContext().getString(R.string.shania_twain), getContext().getString(R.string.luis_fonsi),
                getContext().getString(R.string.tiwa_savage), getContext().getString(R.string.davido), getContext().getString(R.string.dj_khaled),
                getContext().getString(R.string.drake), getContext().getString(R.string.jcole), getContext().getString(R.string.sia),
                getContext().getString(R.string.alicia_keys)
        };

        final ArrayList<TrackInfo> tracklist = new ArrayList<TrackInfo>();

        for (int i = 0; i < 10; i++) {
            tracklist.add(new TrackInfo(TrackTitle[i], Artist[i], AlbumArt[i]));
        }

        // Create the adapter to convert the array to views
        MusicAdapter adapter = new MusicAdapter(getActivity(), tracklist);

        //Create an object of the ListView
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TrackInfo trackInfo = tracklist.get(position);
                //Getting the track title
                String headText = trackInfo.getHeadText();
                // Getting the image resource id for the track
                int imageResourceID = trackInfo.getImage();
                // Getting the artist text
                String description = trackInfo.getDescText();


                Intent now_playing = new Intent(getActivity(), NowPlayingActivity.class);
                //Passing the track title to the NowPlayingActivity
                now_playing.putExtra(getContext().getString(R.string.head_text), headText);
                //Passing the image id to the NowPlayingActivity
                now_playing.putExtra(getContext().getString(R.string.image_resource_id), imageResourceID);
                //Passing the artist text to the NowPlayingActivity
                now_playing.putExtra(getContext().getString(R.string.description), description);
                startActivity(now_playing);
            }
        });

        return rootView;
    }

}