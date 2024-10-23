package org.musicas.tests.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.musicas.core.domain.Album;
import org.musicas.core.domain.Artist;
import org.musicas.core.dto.result.ArtistDTO;
import org.musicas.core.dto.usecase.GetArtistUseCaseDTO;
import org.musicas.core.port.MusicRepository;
import org.musicas.core.usecase.GetArtistUseCase;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GetArtistUseCaseTests {

    @Mock
    MusicRepository mockMusicRepository;

    @Test
    @DisplayName("Successfully get artist")
    public void getArtistSuccess() {
        // Arrange
        GetArtistUseCase getArtist = new GetArtistUseCase(mockMusicRepository);

        Artist radiohead = new Artist("Radiohead");
        Album inRainbows = new Album("In Rainbows", radiohead);
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(inRainbows);
        radiohead.setAlbums(albums);
        when(mockMusicRepository.getArtist(anyInt())).thenReturn(radiohead);

        GetArtistUseCaseDTO dto = new GetArtistUseCaseDTO(12);

        // Act
        ArtistDTO result = getArtist.execute(dto);

        // Assert
        assertEquals("Radiohead", result.getName());
        assertEquals(1, result.getAlbums().size());
        assertEquals("In Rainbows", result.getAlbums().get(0).getTitle());
    }

    // TODO : Test when artist has no albums

    // TODO : Test when artist does not exist

}
