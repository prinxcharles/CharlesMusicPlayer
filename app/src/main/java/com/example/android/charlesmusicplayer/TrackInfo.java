package com.example.android.charlesmusicplayer;
public class TrackInfo {

    public String heading;
    public String description;
    public int imageResource;

    public TrackInfo(String heading, String description, int imageResource) {
        this.heading = heading;
        this.description = description;
        this.imageResource = imageResource;
    }
    public String getHeadText(){return heading;}
    public String getDescText(){return description;}
    public int getImage(){return imageResource;}


}
