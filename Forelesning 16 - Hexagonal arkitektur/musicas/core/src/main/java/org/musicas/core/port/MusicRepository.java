package org.musicas.core.port;

import org.musicas.core.domain.Album;
import org.musicas.core.domain.Artist;

import java.util.ArrayList;

/*
Dette er hva vi i hexagonal arkitecture kaller for en port. Den beskriver oppførselen til et repository (persistent
lagring) men ikke hvordan denne oppførselen er implementert. Det gjøres typisk i en egen modul hvor man lager en
klasse, f.eks. SQLDatabase e.l. som implementerer dette interfacet, og dermed også de abstrakte metodene.
 */

/**
 * Port for a music repository, representing the requirements of a persistent storage implementation of the system's
 * music related data. Defines abstract methods describing behavior such as creating and retrieving various
 * music related objects based on the system's domain models.
 */
public interface MusicRepository {
    void createArtist(Artist artist);

    /**
     * Gets an artist by id including the artists albums.
     *
     * @param id The id of the requested artist.
     * @return The artist.
     */
    Artist getArtist(int id);

    /**
     * Gets a list of albums by a specified artist.
     *
     * @param artistId The id of the artist whose albums to retrieve.
     * @return The albums of the specified artist.
     */
    ArrayList<Album> getAlbumsByArtist(int artistId);
}
