package org.musicas.core.domain;

import java.util.ArrayList;

public class Album extends Music{

    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String title, Artist artist) {
        super(title, artist);
    }

    public ArrayList<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
