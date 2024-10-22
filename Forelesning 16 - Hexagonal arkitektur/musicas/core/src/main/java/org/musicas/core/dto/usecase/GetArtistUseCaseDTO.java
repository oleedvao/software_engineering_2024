package org.musicas.core.dto.usecase;

public class GetArtistUseCaseDTO {

    private int id;

    public GetArtistUseCaseDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
