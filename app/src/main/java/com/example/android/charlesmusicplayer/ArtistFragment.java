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

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistFragment extends Fragment {


    public ArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for number of albums and tracks for each artist
        String[] TrackCount = new String[]{
                getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track),
                getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track),
                getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track), getContext().getString(R.string.one_album_one_track),
                getContext().getString(R.string.one_album_one_track)
        };

        // Array of Image resourcess for the album arts
        int[] AlbumArt = new int[]{
                R.drawable.sakordie_ft_runtown, R.drawable.shana_twain, R.drawable.despacito, R.drawable.tiwa_savage_all_over, R.drawable.davido_nwa_baby,
                R.drawable.dj_khaled_im_the_one_track_art, R.drawable.drake_in_my_feelings, R.drawable.jcole_farewell_album_art, R.drawable.sia_house_on_fire_track_art,
                R.drawable.alicia_keys_try_sleeping_with_a_broken_heart_track_art
        };

        String[] Artiste = new String[]{
                getContext().getString(R.string.sarkodie_ft_runtown), getContext().getString(R.string.shania_twain), getContext().getString(R.string.luis_fonsi),
                getContext().getString(R.string.tiwa_savage), getContext().getString(R.string.davido), getContext().getString(R.string.dj_khaled),
                getContext().getString(R.string.drake), getContext().getString(R.string.jcole), getContext().getString(R.string.sia),
                getContext().getString(R.string.alicia_keys)
        };

        // Creates an array of an array which contains all the info to be passed to the ListView
        final ArrayList<TrackInfo> tracklist = new ArrayList<TrackInfo>();

        for (int i = 0; i < 10; i++) {
            tracklist.add(new TrackInfo(Artiste[i], TrackCount[i], AlbumArt[i]));
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
                //Getting the headText(artiste)
                String headText = trackInfo.getHeadText();
                // Getting the image resource id for the track
                int imageResourceID = trackInfo.getImage();
                // Getting the artist text
                String description = trackInfo.getDescText();


                Intent selected_artiste = new Intent(getActivity(), InfoActivity.class);
                //Pass the selected artiste and accompanying details info to the InfoActivity
                selected_artiste.putExtra(getContext().getString(R.string.head_text), headText);
                selected_artiste.putExtra(getContext().getString(R.string.image_resource_id), imageResourceID);
                selected_artiste.putExtra(getContext().getString(R.string.description), description);
                //Pass the position of the selected item to the InfoActivity
                selected_artiste.putExtra(getContext().getString(R.string.position), position);
                startActivity(selected_artiste);


            }
        });

        return rootView;
    }
}
