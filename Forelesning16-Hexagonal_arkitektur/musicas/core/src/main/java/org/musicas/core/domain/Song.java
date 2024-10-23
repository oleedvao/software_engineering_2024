package org.musicas.core.domain;

public class Song extends Music{

    private int lengthInSeconds;
    private Album album;

    public Song(String title, Artist artist, int lengthInSeconds, Album album) {
        super(title, artist);
        this.album = album;
        this.lengthInSeconds = lengthInSeconds;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
}
