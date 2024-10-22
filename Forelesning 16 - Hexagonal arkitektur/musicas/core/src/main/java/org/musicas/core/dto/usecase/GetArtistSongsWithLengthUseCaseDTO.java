package org.musicas.core.dto.usecase;

public class GetArtistSongsWithLengthUseCaseDTO {

    private int artistId;
    private int lengthInSeconds;

    public GetArtistSongsWithLengthUseCaseDTO(int artistId, int lengthInSeconds) {
        this.artistId = artistId;
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
}
