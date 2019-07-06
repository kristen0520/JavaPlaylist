package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    ArrayList<Song> tracks;
    String band;
    String title;

    public Album(ArrayList<Song> tracks, String band, String title) {
        this.tracks = tracks;
        this.band = band;
        this.title = title;
    }

    public ArrayList<Song> getTracks() {
        return this.tracks;
    }

    public void setTracks(ArrayList<Song> tracks) {
        this.tracks = tracks;
    }

    public String getBand() {
        return band;
    }

    public String getTitle() {
        return title;
    }


}
