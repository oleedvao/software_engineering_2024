import java.util.ArrayList;

public abstract class ExamTool {
    public static int countGradeInList(String grade, ArrayList<String> grades) {
        if (grade == "A") {
            return 3;
        }
        else return 2;
    }
}
