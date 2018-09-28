package com.example.android.charlesmusicplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.charlesmusicplayer.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    List<TrackInfo> tracklist;

    // Make the Up button behave like the back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        //Getting the intent with the track title, image resource ID and description for the selected file
        Intent now_playing = getIntent();
        String headText = now_playing.getStringExtra(getString(R.string.head_text));
        int image = now_playing.getIntExtra(getString(R.string.image_resource_id), 0);
        String description = now_playing.getStringExtra(getString(R.string.description));
        int position = now_playing.getIntExtra(getString(R.string.position), 0);

        // Set the label for the activity
        this.setTitle(headText);

        //create data
        tracklist = DummyContent.getData();
        TrackInfo tracks = tracklist.get(position);

        String TrackTitle = tracks.getHeadText();
        String Artist = tracks.getDescText();
        int AlbumArt = tracks.getImage();

        final ArrayList<TrackInfo> tracklist = new ArrayList<TrackInfo>();
        tracklist.add(new TrackInfo(TrackTitle, Artist, AlbumArt));

        // Create the adapter to convert the array to views
        MusicAdapter adapter = new MusicAdapter(InfoActivity.this, tracklist);

        //Create an object of the ListView
        ListView listView = findViewById(R.id.list);
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

                Intent now_playing = new Intent(InfoActivity.this, NowPlayingActivity.class);
                //Passing the track title to the NowPlayingActivity
                now_playing.putExtra(getString(R.string.head_text), headText);
                //Passing the image id to the NowPlayingActivity
                now_playing.putExtra(getString(R.string.image_resource_id), imageResourceID);
                //Passing the artist text to the NowPlayingActivity
                now_playing.putExtra(getString(R.string.description), description);
                startActivity(now_playing);
            }
        });

    }
}
