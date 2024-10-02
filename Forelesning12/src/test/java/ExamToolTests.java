import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ExamToolTests {

    @Test
    @DisplayName("Count grade in list of grades")
    public void countGradeInList() {

        ExamTool examTool = new ExamTool();
        ArrayList<String> grades = new ArrayList<>();
        Collections.addAll(grades,
                "A", "B", "B", "A", "C", "D", "A");

        int countA = examTool.countGradeInList("A", grades);

        Assertions.assertEquals(3, countA);

    }

}
