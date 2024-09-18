import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DangerZoneTests {

    /*
    Denne enhetstesten tester at metoden killSwitch() kaster en RuntimeException.
    Merk at når vi gjør dette i en Assertion vil ikke programmet krasje. Den vil i så fall bare sjekke at
    funksjonskallet HADDE krasjet om det blir kjørt.
    Merk også at metoden assertThrows forventer to parametere. Første må være exception-klassen som vi forventer blir
    kastet, og den andre må være en "executable", som vi kan definere med lambda notasjon ( () -> <kjørbar kode> ).
     */
    @Test
    @DisplayName("Kill switch is set to true and kills the program")
    public void killSwitchTrue() {
        DangerZone dangerZone = new DangerZone();

        Assertions.assertThrows(
                RuntimeException.class,
                () -> dangerZone.killSwitch(true)
        );
    }

    /*
    Denne enhetstesten kontrollerer at the ikke blir kastet noen form for exception.
    For dette kan vi benytte assertDoesNotThrow(), som krever en executable som parameter. Som forklart ved enhetstesten
    over kan vi gjøre dette ved å skrive et lambda-utrykk.
     */
    @Test
    @DisplayName("Kill switch is set to false and spares the program from harm")
    public void killSwitchFalse() {
        DangerZone dangerZone = new DangerZone();

        Assertions.assertDoesNotThrow( () -> dangerZone.killSwitch(false) );
    }
}
