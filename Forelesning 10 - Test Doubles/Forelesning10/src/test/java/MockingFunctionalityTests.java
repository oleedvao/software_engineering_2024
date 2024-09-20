import model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/*
Denne klassen er bare for demonstrere mock-funksjonalitet. Altså er ikke dette ett godt eksempel av hvor man hadde
benyttet mocking i praksis. Se MovieDescriberTests for et mer realistisk eksempel av bruk.
 */
@ExtendWith(MockitoExtension.class)
public class MockingFunctionalityTests {

    // Dette er en global mock deklarasjon og kan benyttes og tilpasses unit i alle tester
    @Mock
    Calculator mockCalculator;

    /*
    Ett mock objekt er en "etterligning" av et faktisk objekt. Det har de samme metodene, men ingen av dem har noen
    implementert funksjonalitet og vil i stedet returnere en standard-verdi med mindre vi spesifiserer noe annet i
    testen. Å spesifisere hvilke verdier som skal returneres av mock-objekter sine metoder kalles å stubbe. Dette
    funker nesten som å sette en "if-test" for metode-bruk: "Når eksempelMetode(), blir kalt med parametere X så skal
    den gi X som returverdi". Dette hva vi ser definert med Mockito.when() og Mockito.doReturn.
    Vi kan også verifisere bruk av metoder i et mock-objekt, slikt som om en metode blir kalt, hvor mange ganger,
    rekkefølge av metode-kall osv. Dette er hva vi sjekker med Mockito.verify().

     */
    @Test
    @DisplayName("Demonstrate mocking functionality")
    public void mockingFunctionality() {

        //Calculator calculator = new Calculator();
        //Calculator mockCalculator = Mockito.mock(Calculator.class);
        Mockito.when(mockCalculator.addition(2, 5)).thenReturn(7);
        //Mockito.when(mockCalculator.addition(10, 10)).thenReturn(20);
        //Alternativ måte å definere betingelse og returverdi:
        Mockito.doReturn(20).when(mockCalculator).addition(10, 10);

        int result = mockCalculator.addition(2, 5);
        int result2 = mockCalculator.addition(10, 10);

        Assertions.assertEquals(7, result);
        Assertions.assertEquals(20, result2);
        Mockito.verify(mockCalculator).addition(2, 5);
        Mockito.verify(mockCalculator, Mockito.times(2))
                .addition(Mockito.anyInt(), Mockito.anyInt());


    }

}
