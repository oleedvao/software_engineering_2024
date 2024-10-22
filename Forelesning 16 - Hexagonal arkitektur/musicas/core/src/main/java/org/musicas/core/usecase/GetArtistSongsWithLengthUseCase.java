package org.musicas.core.usecase;

import org.musicas.core.domain.Album;
import org.musicas.core.domain.Song;
import org.musicas.core.dto.result.ArtistSongsWithLengthDTO;
import org.musicas.core.dto.usecase.GetArtistSongsWithLengthUseCaseDTO;
import org.musicas.core.port.MusicRepository;

import java.util.ArrayList;

/**
 * Gets a list of songs by a specified artist that is at least a specified length in seconds.
 */
public class GetArtistSongsWithLengthUseCase {

    private MusicRepository musicRepository;

    public GetArtistSongsWithLengthUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    /**
     * Gets the songs of at least the specified length in seconds.
     *
     * @param dto Use case DTO containing the id of the artist and the minimum length of the songs to be returned.
     * @return ArtistSongsWithLenghtDTO containing a list of the songs with at least the specified length.
     */
    public ArtistSongsWithLengthDTO execute(GetArtistSongsWithLengthUseCaseDTO dto) {
        ArrayList<Album> albumsByArtist = musicRepository.getAlbumsByArtist(dto.getArtistId());

        ArrayList<Song> songsWithLength = new ArrayList<>();

        for (Album album : albumsByArtist) {
            for (Song song : album.getSongs()) {
                if (song.getLengthInSeconds() >= dto.getLengthInSeconds()) {
                    songsWithLength.add(song);
                }
            }
        }

        return new ArtistSongsWithLengthDTO(songsWithLength);
    }
}
