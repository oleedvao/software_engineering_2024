package org.musicas.core.dto;

public class CreateArtistUseCaseDTO {

    private String name;

    public CreateArtistUseCaseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
