package com.example.android.charlesmusicplayer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class NowPlayingActivity extends AppCompatActivity {

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
        setContentView(R.layout.now_playing);

        //Getting the intent with the track title, image resource ID and description for the selected file
        Intent now_playing = getIntent();
        String title = now_playing.getStringExtra(getString(R.string.head_text));
        int image = now_playing.getIntExtra(getString(R.string.image_resource_id), 0);
        String description = now_playing.getStringExtra(getString(R.string.description));

        //Image view to be blurred
        ImageView bgImgView = (ImageView) findViewById(R.id.now_playing_background);
        bgImgView.setImageResource(image);

        //Get the bitmap from the ImageView.
        Bitmap bitmap = ((BitmapDrawable) bgImgView.getDrawable()).getBitmap();

        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        bgImgView.setImageBitmap(new BlurUtils().blur(NowPlayingActivity.this, bitmap, 10.5f));

        //Setting the image
        ImageView imageView = (ImageView) findViewById(R.id.image_resource);
        imageView.setImageResource(image);

        //Setting the track title
        TextView headText = (TextView) findViewById(R.id.track_header);
        headText.setText(title);

        // Set the artist/genre/album
        TextView trackDescription = (TextView) findViewById(R.id.track_description);
        trackDescription.setText(description);
    }
}