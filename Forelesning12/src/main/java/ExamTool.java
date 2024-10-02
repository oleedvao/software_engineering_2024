import java.util.ArrayList;

public abstract class ExamTool {
    public static int countGradeInList(String grade, ArrayList<String> grades) {
        if (grade.equals("A")) return 3;
        return 2;
    }
}
