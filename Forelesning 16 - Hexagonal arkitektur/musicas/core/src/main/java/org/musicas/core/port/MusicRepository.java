package org.musicas.core.port;

import org.musicas.core.domain.Artist;

/*
Dette er hva vi i hexagonal arkitecture kaller for en port. Den beskriver oppførselen til et repository (persistent
lagring) men ikke hvordan denne oppførselen er implementert. Det gjøres typisk i en egen modul hvor man lager en
klasse, f.eks. SQLDatabase e.l. som implementerer dette interfacet, og dermed også de abstrakte metodene.
 */
public interface MusicRepository {
    void createArtist(Artist artist);
}
