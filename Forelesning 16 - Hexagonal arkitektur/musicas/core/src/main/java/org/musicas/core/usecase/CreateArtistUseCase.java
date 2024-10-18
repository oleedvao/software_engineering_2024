package org.musicas.core.usecase;

import org.musicas.core.domain.Artist;
import org.musicas.core.dto.CreateArtistDTO;
import org.musicas.core.port.MusicRepository;

/*
Dette er et eksempel på en use case-klasse som definerer en generell handling i systemet (opprette en Artist).
Dette innebærer å motta informasjonen som artisten skal ha (her bare navn), typisk gjennom et definert DTO, og å
lagre den opprettede artisten i systemets løsning for persistent lagring (et repository). Use caset har ikke noe
forhold til nøyaktig hvilket repository som skal være gjeldende, så vi lager en variabel basert på interfacet som
beskriver repositoriet sin oppførsel, og definerer deretter instansieringen av denne variabelen som et krav i klassens
konstruktør. Dette kalles Dependency Injection og er en veldig god teknikk for å sørge for løs kobling mellom enheter.
Fordelen er at vi da kan vente med å spesifisere hvilken implementasjon som skal være gjeldende til når vi skal benytte
use cases, typisk i forbindelse av en input-implementasjon, f.eks. at use caset kjøres fra en implementert
api-kontroller eller lignende.


--Eksempel på tiltenkt bruk (med SQLDatabase som spesifikk repository-implementasjon)--
    SQLDatabase sqlDatabase = new SQLDatabase();  //<-- imlementerer underliggende MusicRepository
    CreateArtistDTO dto = new CreateArtistDTO("Radiohead");  //<-- definerer artistens navn via dedikert DTO
    CreateArtistUseCase createArtist = new CreateArtistUseCase(sqlDatabase);  //<-- spesifiserer at usecaset skal
                                                                                     benytte SQLDatabase som repository
    createArtist.execute(dto);  //<-- kjører use caset
 */
public class CreateArtistUseCase {

    private final MusicRepository musicRepository;

    public CreateArtistUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute(CreateArtistDTO dto) {

        Artist artist = new Artist(dto.getName());
        musicRepository.createArtist(artist);

    }

}
