package com.example.android.charlesmusicplayer;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class AlbumFragment extends Fragment {

    int mColumnCount = 2;

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.album_grid, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.grid);

        // Set the adapter
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), mColumnCount));


        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Array of strings for ListView
        String[] AlbumName = new String[]{
                getContext().getString(R.string.highest), getContext().getString(R.string.up), getContext().getString(R.string.daddy_k_the_mix),
                getContext().getString(R.string.sugarcane), getContext().getString(R.string.unknown), getContext().getString(R.string.grateful),
                getContext().getString(R.string.scorpion), getContext().getString(R.string.friday_nights_lights), getContext().getString(R.string.this_is_acting),
                getContext().getString(R.string.the_element_of_freedom)
        };


        int[] AlbumArt = new int[]{
                R.drawable.sakordie_ft_runtown, R.drawable.shana_twain, R.drawable.despacito, R.drawable.tiwa_savage_all_over, R.drawable.davido_nwa_baby,
                R.drawable.dj_khaled_grateful_album_art, R.drawable.drake_in_my_feelings, R.drawable.jcole_farewell_album_art, R.drawable.sia_house_on_fire_album_art,
                R.drawable.alicia_keys_the_element_of_freedom_album_art
        };

        String[] Artist = new String[]{
                getContext().getString(R.string.sark_1), getContext().getString(R.string.shania_1), getContext().getString(R.string.luis_fonsi_1),
                getContext().getString(R.string.tiwa_savage_1), getContext().getString(R.string.davido_1), getContext().getString(R.string.dj_khaled_1),
                getContext().getString(R.string.drake_1), getContext().getString(R.string.jcole_1), getContext().getString(R.string.sia_1),
                getContext().getString(R.string.alicia_1)
        };

        final List<TrackInfo> albums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            albums.add(new TrackInfo(AlbumName[i], Artist[i], AlbumArt[i]));
        }


        recyclerView.setAdapter(new AlbumsAdapter(albums));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TrackInfo trackInfo = albums.get(position);
                //Getting the track album title
                String headText = trackInfo.getHeadText();
                // Getting the image resource id for the album
                int imageResourceID = trackInfo.getImage();
                // Getting the artist count
                String description = trackInfo.getDescText();


                Intent selected_album = new Intent(getActivity(), InfoActivity.class);
                //Passing the album title to the InfoActivity
                selected_album.putExtra(getContext().getString(R.string.head_text), headText);
                //Passing the image id to the InfoActivity
                selected_album.putExtra(getContext().getString(R.string.image_resource_id), imageResourceID);
                //Passing the artist text to the InfoActivity
                selected_album.putExtra(getContext().getString(R.string.description), description);

                selected_album.putExtra(getContext().getString(R.string.position), position);
                startActivity(selected_album);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return rootView;
    }


    // Special albums adapter class to handle the album grid
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

        public class MyViewHolder extends RecyclerView.ViewHolder {
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

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
