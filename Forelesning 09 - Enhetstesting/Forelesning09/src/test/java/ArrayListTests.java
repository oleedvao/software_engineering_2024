import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayListTests {

    /*
    Denne enhetstesten tester en void-metode (ArrayList sin add()).
    Når vi tester en enhet i form av en void-metode vil ikke metoden returnere et direkte resultat, men vil typisk
    påvirke noe annet.
    I dette tilfellet vil add()-metoden legge til et nytt element i ArrayList-objektet. Altså bør vi teste at det som
    legges til faktisk blir lagt til. Dermed blir resultatet hentet ut gjennom det påvirkede objektet i stedet for å
    bli direkte returnert av add()-metoden.
     */
    @Test
    @DisplayName("Add number to ArrayList")
    public void addNumberToArrayList() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);

        Assertions.assertEquals(3, list.getLast());
    }
}
