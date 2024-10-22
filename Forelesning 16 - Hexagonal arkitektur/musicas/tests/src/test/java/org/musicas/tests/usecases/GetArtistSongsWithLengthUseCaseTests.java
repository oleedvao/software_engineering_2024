package org.musicas.tests.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.musicas.core.domain.Album;
import org.musicas.core.domain.Artist;
import org.musicas.core.domain.Song;
import org.musicas.core.dto.result.ArtistSongsWithLengthDTO;
import org.musicas.core.dto.usecase.GetArtistSongsWithLengthUseCaseDTO;
import org.musicas.core.port.MusicRepository;
import org.musicas.core.usecase.GetArtistSongsWithLengthUseCase;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GetArtistSongsWithLengthUseCaseTests {

    @Mock
    MusicRepository mockMusicRepository;

    /*
    Merk at dette er en rotete test og hadde sikkert hatt godt av å settes opp som en parameterisert test.
     */
    // TODO: make parameterized and add more tests cases
    @Test
    @DisplayName("Successfully get artist songs with length")
    public void getArtistSongsWithLengthSuccess() {
        // Arrange
        GetArtistSongsWithLengthUseCase getSongsWithLength = new GetArtistSongsWithLengthUseCase(mockMusicRepository);

        ArrayList<Album> albums = new ArrayList<>();
        Artist radiohead = new Artist("Radiohead");
        Album inRainbows = new Album("In Rainbows", radiohead);
        inRainbows.addSong(new Song("15 Step", radiohead, 237, inRainbows));
        inRainbows.addSong(new Song("Bodysnatchers", radiohead, 242, inRainbows));
        inRainbows.addSong(new Song("Weird Fishes / Arpeggi", radiohead, 318, inRainbows));
        albums.add(inRainbows);
        when(mockMusicRepository.getAlbumsByArtist(anyInt())).thenReturn(albums);

        GetArtistSongsWithLengthUseCaseDTO dto = new GetArtistSongsWithLengthUseCaseDTO(12, 318);

        // Act
        ArtistSongsWithLengthDTO result = getSongsWithLength.execute(dto);

        // Assert
        assertEquals(1, result.getSongsWithLength().size());
        assertEquals("Weird Fishes / Arpeggi", result.getSongsWithLength().get(0).getTitle());
        assertEquals(318, result.getSongsWithLength().get(0).getLengthInSeconds());

    }

    // TODO : Test for wrong input values such as negative value for length in seconds

    // TODO : Test for artist that does not exist

}
