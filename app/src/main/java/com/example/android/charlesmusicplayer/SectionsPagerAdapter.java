package com.example.android.charlesmusicplayer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.charlesmusicplayer.AlbumFragment;
import com.example.android.charlesmusicplayer.R;
import com.example.android.charlesmusicplayer.TrackFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TrackFragment();
        } else if (position == 1) {
            return new AlbumFragment();
        } else if (position == 2) {
            return new ArtistFragment();
        } else{
            return new GenreFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.tracks);
            case 1:
                return mContext.getString(R.string.albums);
            case 2:
                return mContext.getString(R.string.artists);
            case 3:
                return mContext.getString(R.string.genre);
            default:
                return null;
        }
    }
}

