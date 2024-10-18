package org.musicas.core.port;

import org.musicas.core.domain.Artist;

public interface MusicRepository {
    void createArtist(Artist artist);
}
