package org.musicas.core.dto.result;

import org.musicas.core.domain.Album;

import java.util.ArrayList;

public class ArtistDTO {

    private int id;
    private String name;
    private ArrayList<Album> albums = new ArrayList<>();

    public ArtistDTO(int id, String name, ArrayList<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}
