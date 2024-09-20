import model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingFunctionalityTests {

    @Mock
    Calculator mockCalculator;

    @Test
    @DisplayName("Demonstrate mocking functionality")
    public void mockingFunctionality() {

        //Calculator calculator = new Calculator();
        //Calculator mockCalculator = Mockito.mock(Calculator.class);
        Mockito.when(mockCalculator.addition(2, 5)).thenReturn(7);
        Mockito.when(mockCalculator.addition(10, 10)).thenReturn(20);

        int result = mockCalculator.addition(2, 5);
        int result2 = mockCalculator.addition(10, 10);

        Assertions.assertEquals(7, result);
        Assertions.assertEquals(20, result2);
        Mockito.verify(mockCalculator).addition(2, 5);
        Mockito.verify(mockCalculator, Mockito.times(2))
                .addition(Mockito.anyInt(), Mockito.anyInt());


    }

}
