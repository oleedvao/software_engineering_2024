import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InformationCheckerTests {

    @Test
    @DisplayName("Age is within accepted range")
    public void controlAgeWithinAcceptedRange() {
        //Arrange
        InformationChecker informationChecker = new InformationChecker();

        //Act
        int result = informationChecker.controlAge(30);
        int result2 = informationChecker.controlAge(0);
        int result3 = informationChecker.controlAge(120);

        //Assert
        Assertions.assertEquals(30, result);
        Assertions.assertEquals(0, result2);
        Assertions.assertEquals(120, result3);
    }

    

}
