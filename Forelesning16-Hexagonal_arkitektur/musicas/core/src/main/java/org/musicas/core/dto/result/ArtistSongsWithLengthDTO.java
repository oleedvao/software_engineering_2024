package org.musicas.core.dto.result;

import org.musicas.core.domain.Song;

import java.util.ArrayList;

public class ArtistSongsWithLengthDTO {

    ArrayList<Song> songsWithLength;

    public ArtistSongsWithLengthDTO(ArrayList<Song> songsWithLength) {
        this.songsWithLength = songsWithLength;
    }

    public ArrayList<Song> getSongsWithLength() {
        return songsWithLength;
    }

    public void setSongsWithLength(ArrayList<Song> songsWithLength) {
        this.songsWithLength = songsWithLength;
    }
}
