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

    @Test
    @DisplayName("Age is less than accepted range")
    public void controlAgeLessThanAcceptedRange() {
        //Arrange
        InformationChecker informationChecker = new InformationChecker();

        //Act
        int result = informationChecker.controlAge(-1);
        int result2 = informationChecker.controlAge(Integer.MIN_VALUE);

        //Assert
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(0, result2);
    }

    @Test
    @DisplayName("Age is greater than accepted range")
    public void controlAgeGreaterThanAcceptedRange() {
        InformationChecker informationChecker = new InformationChecker();

        int result = informationChecker.controlAge(300);
        int result2 = informationChecker.controlAge(121);
        int result3 = informationChecker.controlAge(Integer.MAX_VALUE);

        Assertions.assertEquals(120, result);
        Assertions.assertEquals(120, result2);
        Assertions.assertEquals(120, result3);
    }

}
