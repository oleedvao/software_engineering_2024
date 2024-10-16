package org.musicas.core.domain;

public class Song extends Music{

    private Album album;

    public Song(String title, Artist artist, Album album) {
        super(title, artist);
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
