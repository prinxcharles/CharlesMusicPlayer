package com.example.android.charlesmusicplayer.dummy;

import android.media.MediaPlayer;

import com.example.android.charlesmusicplayer.R;
import com.example.android.charlesmusicplayer.TrackInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class DummyContent {

    public DummyContent() {

    }

    public static ArrayList<TrackInfo> getData() {

        // Array of strings for ListView Title
        String[] TrackTitle = new String[]{
                "Painkiller", "When You Kiss Me", "Despacito", "All Over", "Nwa Baby", "I'm The One", "In My Feelings", "Farewell", "House On Fire",
                "Try Sleeping With A Broken Heart"
        };


        int[] AlbumArt = new int[]{
                R.drawable.sakordie_ft_runtown, R.drawable.shana_twain, R.drawable.despacito, R.drawable.tiwa_savage_all_over, R.drawable.davido_nwa_baby,
                R.drawable.dj_khaled_im_the_one_track_art,R.drawable.drake_in_my_feelings,R.drawable.jcole_farewell_album_art,R.drawable.sia_house_on_fire_track_art,
                R.drawable.alicia_keys_try_sleeping_with_a_broken_heart_track_art
        };

        String[] Artist = new String[]{
                "Sarkodie ft Runtown", "Shania Twain", "Luis Fonsi ft. DaddyYankee", "Tiwa Savage",
                "Davido", "DJ Khaled ft. Justin Bieber", "Drake", "JCole","Sia", "Alicia Keys"
        };

        final ArrayList<TrackInfo> tracklist = new ArrayList<TrackInfo>();


        for (int i = 0; i < 10; i++) {
            tracklist.add(new TrackInfo(TrackTitle[i],Artist[i],AlbumArt[i] ));
        }
        return tracklist;
    }
}
