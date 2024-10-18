package org.musicas.core.dto;

/*
Dette er en DTO-klasse som spesifikt benyttes i forbindelse med opprettelse av Artist-objekter i systemet
(CreateArtistUseCase).
 */
public class CreateArtistDTO {

    private String name;

    public CreateArtistDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
