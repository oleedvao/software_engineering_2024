package org.musicas.core.usecase;

import org.musicas.core.domain.Artist;
import org.musicas.core.dto.CreateArtistUseCaseDTO;
import org.musicas.core.port.MusicRepository;

public class CreateArtistUseCase {

    private final MusicRepository musicRepository;

    public CreateArtistUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute(CreateArtistUseCaseDTO dto) {

        Artist artist = new Artist(dto.getName());
        musicRepository.createArtist(artist);

    }

}
