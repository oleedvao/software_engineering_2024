import java.util.ArrayList;

public abstract class ExamTool {



    public static String gradeExamSubmission(ExamSubmission examSubmission) {
        if (examSubmission.getTotalPoints() >= 90) {
            return "A";
        }
        return "F";
    }

    /*
    Denne enheten er fullstendig skrevet ut ifra TDD.
    Merk at den ikke ble definert til å kunne generelt håndtere telling av flere unike lister før testene uttrykte et
    behov for dette ("triangulation). Før dette ble testene oppnådd med enkle if-tester.
     */
    public static int countGradeInList(String gradeToCount, ArrayList<String> grades) {
        int count = 0;
        for (String gradeInList : grades) {
            if (gradeInList.equals(gradeToCount)) count++;
        }
        return count;
    }


}
