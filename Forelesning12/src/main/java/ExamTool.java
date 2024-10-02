import java.util.ArrayList;

public abstract class ExamTool {
    public static int countGradeInList(String grade, ArrayList<String> grades) {
        if (grade.equals("A")) return 3;
        else if (grade.equals("B")) return 2;
        return 1;
    }
}
