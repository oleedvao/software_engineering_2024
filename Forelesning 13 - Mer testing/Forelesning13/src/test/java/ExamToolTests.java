import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExamToolTests {

    @Test
    @DisplayName("Grade exam submission")
    public void gradeExamSubmission() {

        ExamSubmission examSubmissionA = mock(ExamSubmission.class);
        when(examSubmissionA.getTotalPoints()).thenReturn(95);
        ExamSubmission examSubmissionA2 = mock(ExamSubmission.class);
        when(examSubmissionA2.getTotalPoints()).thenReturn(90);
        ExamSubmission examSubmissionA3 = mock(ExamSubmission.class);
        when(examSubmissionA3.getTotalPoints()).thenReturn(100);

        ExamSubmission examSubmissionB = mock(ExamSubmission.class);
        when(examSubmissionB.getTotalPoints()).thenReturn(89);

        String grade = ExamTool.gradeExamSubmission(examSubmissionA);
        String grade2 = ExamTool.gradeExamSubmission(examSubmissionA2);
        String grade3 = ExamTool.gradeExamSubmission(examSubmissionA3);

        String grade4 = ExamTool.gradeExamSubmission(examSubmissionB);

        assertEquals("A", grade);
        assertEquals("A", grade2);
        assertEquals("A", grade3);

        assertEquals("B", grade4);

    }



    /*
    Se commitene navngitt F12 for en stegvis liste med endringer tilsvarende stegene i Test Driven Development (red,
    green, refactor).
    Disse stegvise endringene virker kanskje banale og unødvendig små, men banker inn dette med å teste ofte og all
    koden, samt å ofte tenke på refaktorering for å sørge for at resultatet blir "god kode".
    Generelt er TDD nyttig i tilfeller hvor man står fast og ikke helt vet hvordan man skal implementere den relevante
    enheten. I slike tilfeller kan TDD veilede deg i riktig retning ved å gjøre små og overkommelige steg.
     */
    @Test
    @DisplayName("Count grade in list of grades")
    public void countGradeInList() {

        //Arrange
        ArrayList<String> grades = new ArrayList<>();
        Collections.addAll(grades,
                "A", "B", "B", "A", "C", "D", "A");
        ArrayList<String> grades2 = new ArrayList<>();
        Collections.addAll(grades2,
                "B", "D", "D", "A", "C", "C");

        //Act
        int countA = ExamTool.countGradeInList("A", grades);
        int countB = ExamTool.countGradeInList("B", grades);
        int countC = ExamTool.countGradeInList("C", grades);
        int countD = ExamTool.countGradeInList("D", grades);
        int countE = ExamTool.countGradeInList("E", grades);
        int countF = ExamTool.countGradeInList("F", grades);

        int countA2 = ExamTool.countGradeInList("A", grades2);
        int countB2 = ExamTool.countGradeInList("B", grades2);
        int countC2 = ExamTool.countGradeInList("C", grades2);
        int countD2 = ExamTool.countGradeInList("D", grades2);
        int countE2 = ExamTool.countGradeInList("E", grades2);
        int countF2 = ExamTool.countGradeInList("F", grades2);

        //Assert
        assertEquals(3, countA);
        assertEquals(2, countB);
        assertEquals(1, countC);
        assertEquals(1, countD);
        assertEquals(0, countE);
        assertEquals(0, countF);

        assertEquals(1, countA2);
        assertEquals(1, countB2);
        assertEquals(2, countC2);
        assertEquals(2, countD2);
        assertEquals(0, countE2);
        assertEquals(0, countF2);

    }

}
