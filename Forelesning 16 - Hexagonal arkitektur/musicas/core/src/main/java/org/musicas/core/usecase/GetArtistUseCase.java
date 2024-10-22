package org.musicas.core.usecase;

import org.musicas.core.domain.Artist;
import org.musicas.core.dto.result.ArtistDTO;
import org.musicas.core.dto.usecase.GetArtistUseCaseDTO;
import org.musicas.core.port.MusicRepository;

/**
 * Gets an artist with their albums based on the artist's id.
 */
public class GetArtistUseCase {

    private MusicRepository musicRepository;

    public GetArtistUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    /**
     * Gets the artist and their albums.
     *
     * @param dto GetArtistUseCaseDTO containing the artist's id.
     * @return ArtistDTO containing id, name and albums.
     */
    public ArtistDTO execute(GetArtistUseCaseDTO dto) {
        Artist artist = musicRepository.getArtist(dto.getId());

        return new ArtistDTO(artist.getId(), artist.getName(), artist.getAlbums());
    }
}
