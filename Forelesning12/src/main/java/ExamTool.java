import java.util.ArrayList;

public abstract class ExamTool {
    public static int countGradeInList(String gradeToCount, ArrayList<String> grades) {
        int count = 0;
        for (String gradeInList : grades) {
            if (gradeInList.equals(gradeToCount)) count++;
        }
        return count;
    }
}
