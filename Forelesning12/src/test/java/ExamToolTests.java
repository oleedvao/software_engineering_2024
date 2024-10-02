import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ExamToolTests {

    @Test
    @DisplayName("Count grade in list of grades")
    public void countGradeInList() {

        ArrayList<String> grades = new ArrayList<>();
        Collections.addAll(grades,
                "A", "B", "B", "A", "C", "D", "A");
        ArrayList<String> grades2 = new ArrayList<>();
        Collections.addAll(grades2,
                "B", "D", "D", "A", "C", "C");

        int countA = ExamTool.countGradeInList("A", grades);
        int countB = ExamTool.countGradeInList("B", grades);
        int countC = ExamTool.countGradeInList("C", grades);
        // ...

        int countA2 = ExamTool.countGradeInList("A", grades2);

        Assertions.assertEquals(3, countA);
        Assertions.assertEquals(2, countB);
        Assertions.assertEquals(1, countC);
        //...

        Assertions.assertEquals(1, countA2);

    }

}
