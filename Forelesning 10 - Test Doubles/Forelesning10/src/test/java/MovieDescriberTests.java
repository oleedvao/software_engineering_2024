import model.Movie;
import model.MovieDescriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MovieRepository;

/*
Denne test-klassen tester ENHETEN MovieDescriber, som i dette tilfellet er en hel klasse. MovieDescriber kan anses som
en enhet fordi den har ett overordnet ansvar: Å beskrive en gitt film. Likevel vil en slik MovieDescriber være avhengig
av andre enheter i konteksten av et større system. For eksempel må en MovieDescriber ha et form for Movie-objekt som
den kan beskrive, som videre innebærer at den må hente Movie-objektet fra noe (f.eks. en database eller et filsystem).
Disse er imidlertid egne ansvarsområder og bør skilles ut i egne enheter (her MovieRepository for å representere en
komponent som kan gi Movie-objekter på et vis, og selve Movie-klassen som beskriver datatypen). MovieDescriber sin
funksjonalitet vil altså være avhengig av disse enhetene. Dette dumt når vi enhetstester fordi vi ikke kan
være sikker på at feil som oppstår er grunnet i enheten selv, men kan potensielt stamme fra enten MovieRepository eller
Movie, eller begge. Vi ønsker å isolere MovieDescriber sin funksjonalitet for testen sin skyld, så vi mocker
MovieRepository og Movie og forfalsker resultater, slik at vi kan fokusere på MovieDescriber alene. Med andre ord
spesifiserer vi antagelser for hvordan MovieRepository og Movie vil fungere og kan være trygge på at
implementasjonsdetaljer i disse ikke forvirrer testresultatene. Det eneste som er viktig er at vi vet formatet av
dataene som de produserer og som vi i tur benytter. Det kan altså være fornuftig å lese dokumentasjonen til enhetene
vi er avhengige av, eller spørre utviklerene som er ansvarlig for disse.
 */
@ExtendWith(MockitoExtension.class)
public class MovieDescriberTests {

    @Mock
    MovieRepository mockMovieRepo;

    @Mock
    Movie mockMovie;


    /*
    Denne enhetstesten sjekker at vi kan beskrive et Movie-objekt under antagelse av at vi får et riktig Movie-objekt
    med riktig informasjon.
    Vi ser at vi forfalsker betingede kall på mockMovieRepo.getMovieByTitle(), mockMovie.getTitle() og
    mockMovie.getRunTimeInMinutes(), som alle blir kalt som en del av enheten vi tester (movieDescriber.describeMovie())
    På den måten antar vi både at movieDescriber-objektet får et gyldig Movie-objekt fra MovieRepository og at dette
    objektet inneholder riktig informasjon for navn og runtime. Dermed vil testen nå bare avhenge av koden som er
    direkte innehold i MovieDescriber sin metode, describeMovie().
     */
    @Test
    @DisplayName("Describe movie")
    public void describeMovie() {

        //Arrange
        MovieDescriber movieDescriber = new MovieDescriber(mockMovieRepo);
        Mockito.when(mockMovieRepo.getMovieByTitle("Fight Club")).thenReturn(mockMovie);
        Mockito.when(mockMovie.getTitle()).thenReturn("Fight Club");
        Mockito.when(mockMovie.getRuntimeInMinutes()).thenReturn(139);

        //Act
        String result = movieDescriber.describeMovie("Fight Club");

        //Assert
        String expected = "The movie Fight Club has a runtime of 139 minutes.";
        Assertions.assertEquals(expected, result);

    }

    /*
    Her tester vi tilfellet hvor vi forsøker å beskrive en film som ikke eksisterer. Altså vil vi her gjøre en antagelse
    om at MovieRepository ikke finner filmen vi spesifiserer og dermed ikke returnerer noe Movie-objekt. Dermed
    benytter vi en mock av MovieRepository til å stubbe getMovieByTitle() til å alltid returnere null (nå er dette
    egentlig standardverdien for mocken, men vi burde fremdeles spesifisere dette for å gjøre testen forståelig).
    Med denne antagelsen kan vi trygt teste at vi får riktig beskrivelse når en film ikke eksisterer.
     */
    @Test
    @DisplayName("Describe movie not found")
    public void describeMovieNotFound() {
        //Arrange
        MovieDescriber movieDescriber = new MovieDescriber(mockMovieRepo);
        Mockito.when(mockMovieRepo.getMovieByTitle(Mockito.anyString())).thenReturn(null);

        //Act
        String result = movieDescriber.describeMovie("Bingus");

        //Assert
        Assertions.assertEquals("The movie could not be found.", result);
    }

}
