package org.musicas.tests.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.musicas.core.domain.Artist;
import org.musicas.core.dto.CreateArtistUseCaseDTO;
import org.musicas.core.port.MusicRepository;
import org.musicas.core.usecase.CreateArtistUseCase;

@ExtendWith(MockitoExtension.class)
public class CreateArtistUseCaseTests {

    @Mock
    MusicRepository mockMusicRepository;

    @Test
    @DisplayName("Successfully create artist")
    public void creatArtistSuccess() {
        //Arrange
        CreateArtistUseCase createArtistUseCase = new CreateArtistUseCase(mockMusicRepository);
        CreateArtistUseCaseDTO dto = new CreateArtistUseCaseDTO("Radiohead");

        //Act
        createArtistUseCase.execute(dto);

        //Assert
        Mockito.verify(mockMusicRepository, Mockito.times(1)).
                createArtist(Mockito.any(Artist.class));
    }
}
