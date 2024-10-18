package org.musicas.tests.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.musicas.core.domain.Artist;
import org.musicas.core.dto.CreateArtistDTO;
import org.musicas.core.port.MusicRepository;
import org.musicas.core.usecase.CreateArtistUseCase;

@ExtendWith(MockitoExtension.class)
public class CreateArtistUseCaseTests {

    @Mock
    MusicRepository mockMusicRepository;

    /*
    Veldig enkel test for CreateArtistUseCase. Use caset er egentlig avhengig av en implementasjon av MusicRepository
    så vi mocker denne.
    Denne testen vil egentlig beskrive hvordan use case-klassen vil brukes i en implementasjon, men vi hadde
    selvfølgelig byttet ut mock-objektet med en et objekt av en klasse som faktisk implementerer MusicRepository.
     */
    @Test
    @DisplayName("Successfully create artist")
    public void createArtistSuccess() {
        //Arrange
        CreateArtistUseCase createArtistUseCase = new CreateArtistUseCase(mockMusicRepository);
        CreateArtistDTO dto = new CreateArtistDTO("Radiohead");

        //Act
        createArtistUseCase.execute(dto);

        //Assert
        Mockito.verify(mockMusicRepository, Mockito.times(1)).
                createArtist(Mockito.any(Artist.class));
    }
}
