package com.example.android.charlesmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenreFragment extends Fragment {

    public GenreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);


        // Array of strings for ListView Title
        String[] TrackTitle = new String[]{
                "1 track", "1 track", "1 track", "1 track", "1 track", "1 track", "1 track", "1 track", "1 track",
                "1 track"
        };


        int[] AlbumArt = new int[]{
                R.drawable.sakordie_ft_runtown, R.drawable.shana_twain, R.drawable.despacito, R.drawable.tiwa_savage_all_over, R.drawable.davido_nwa_baby,
                R.drawable.dj_khaled_im_the_one_track_art,R.drawable.drake_in_my_feelings,R.drawable.jcole_farewell_album_art,R.drawable.sia_house_on_fire_track_art,
                R.drawable.alicia_keys_try_sleeping_with_a_broken_heart_track_art
        };


        String [] Genre = new String[]{
                getContext().getString(R.string.r_n_b_soul), getContext().getString(R.string.country_pop), getContext().getString(R.string.latin_pop),
                getContext().getString(R.string.afropop),getContext().getString(R.string.afropop), getContext().getString(R.string.hip_hop_r_n_b),
                getContext().getString(R.string.hip_hop_rap), getContext().getString(R.string.hip_hop_rap), getContext().getString(R.string.pop), getContext().getString(R.string.contemporary_r_n_b)
        };


        final ArrayList<TrackInfo> tracklist = new ArrayList<TrackInfo>();

        for (int i = 0; i < 10; i++) {
            tracklist.add(new TrackInfo(Genre[i],TrackTitle[i],AlbumArt[i] ));
        }

        // Create the adapter to convert the array to views
        MusicAdapter adapter = new MusicAdapter(getActivity(), tracklist );

        //Create an object of the ListView
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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




                Intent selected_genre = new Intent(getActivity(), InfoActivity.class);
                //Passing the Genre to the InfoActivity
                selected_genre.putExtra(getContext().getString(R.string.head_text), headText);
                //Passing the image id to the NowPlayingActivity
                selected_genre.putExtra(getContext().getString(R.string.image_resource_id), imageResourceID);
                //Passing the artist count text to the NowPlayingActivity
                selected_genre.putExtra(getContext().getString(R.string.description), description);

                selected_genre.putExtra(getContext().getString(R.string.position), position);

                startActivity(selected_genre);


            }
        });


        return rootView;


    }

}
