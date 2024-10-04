import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExamToolTests {

    /*
    Denne metoden samler "parameterene" til testen gradeExamSubmission().
    Det som samles som parametere er typisk det som skal testes (verdi, objekt e.l.) og tilhørende forventet resultat,
    altså de forskjellige test-scenariene. Her gjelder dette et ExamSubmission-objekt og en tiltenkt karakter.
    Det er også vanlig å samle resten av det som hører til "Arrange" delen av testen her, slik som opprettelse av
    objekter eller mock-objekter.
    Merk at vi også kan sende med verdier i parameteren som ikke direkte er påkrevd av testen, men som hjelper med å
    tilpasse output per scenario. Her sender vi for eksempel med poengene for det gjeldende ExamSubmission-objektet
    men hensikt å benytte dette for å definere output per scenario.
     */
    private static Stream<Arguments> gradeExamSubmissionParameters() {
        // Arrange (her mock-objektene som benyttes i testen)
        ExamSubmission examSubmissionA = mock(ExamSubmission.class);
        when(examSubmissionA.getTotalPoints()).thenReturn(95);
        ExamSubmission examSubmissionA2 = mock(ExamSubmission.class);
        when(examSubmissionA2.getTotalPoints()).thenReturn(90);
        ExamSubmission examSubmissionA3 = mock(ExamSubmission.class);
        when(examSubmissionA3.getTotalPoints()).thenReturn(100);

        ExamSubmission examSubmissionB = mock(ExamSubmission.class);
        when(examSubmissionB.getTotalPoints()).thenReturn(89);
        ExamSubmission examSubmissionB2 = mock(ExamSubmission.class);
        when(examSubmissionB2.getTotalPoints()).thenReturn(80);

        // "Scenariene" som skal testes returneres som en Stream og Arguments.
        // Hvert Aruguments.of() definerer her et mock-objekt av ExamSubmission, en forventet karakter for denne og
        // dens totale poeng
        return Stream.of(
                Arguments.of(examSubmissionA, "A", examSubmissionA.getTotalPoints()),
                Arguments.of(examSubmissionA2, "A", examSubmissionA2.getTotalPoints()),
                Arguments.of(examSubmissionA3, "A", examSubmissionA3.getTotalPoints()),
                Arguments.of(examSubmissionB, "B", examSubmissionB.getTotalPoints()),
                Arguments.of(examSubmissionB2, "B", examSubmissionB2.getTotalPoints())
        );
    }

    /*
    Dette er en parameterisert test, som betyr at testen tar imot generelle parametere som den skal håndtere.
    Parametereiserte tester benyttes typisk til å definere test-logikken generelt, mens verdier for konkrete
    test-scenarier blir tatt imot som parametere.
    For at en test skal tolkes av JUnit som en parameterisert test, må vi benytte @ParameterizedTest, og eventuelt
    definere et "name", som bestemmer hvordan outputen vil bli for hvert scenarie.
        Merk at vi for name refererer til test-metoden sine parametere ved bruk av indexer. Under referer for eksempel
        {0} til examSubmission-parameteren, {1} til expectedGrade-parameteren og {2} til totalPoints-parameteren.
    Vi må også definere en @MethodSource som spesifiserer navnet på Parameter metoden. Altså hvor parameterene skal
    komme fra. Dette vil i praksis medføre at JUnit kjørerer testen for alle "argumentene" definert i
    test-parameter-metoden. Men for å kunne ta nytte av verdiene som kommer fra dette, må vi også definere parametere
    i selve test-metoden som representerer disse. Parameterene examSubmission, expectedGrade og totalPoints er altså
    generelle referanse til de verdiene som kommer fra test-parameter-metoden gradeExamSumbissionParameters().
     */
    @ParameterizedTest(name = "Exam with {2} points is graded {1}")
    @MethodSource("gradeExamSubmissionParameters")
    @DisplayName("Grade exam submission")
    public void gradeExamSubmission(ExamSubmission examSubmission, String expectedGrade, int totalPoints) {

        // Act er her definert én gang og vil dynamisk gjøre det samme for alle examSubmission-objekter som blir testet.
        String actualGrade = ExamTool.gradeExamSubmission(examSubmission);

        // Assert er her definert én gang og vil dynamisk kontrollere at karakteren blir riktig (expectedGrade) for
        // hver beregning.
        assertEquals(expectedGrade, actualGrade);

    }


    /*
    Parametere for testen countGradeInList().
    Definerer listene som skal testes for og alle scenariene som testes (karakter som skal telles, listen den skal
    telles i, og forventet antall fra tellingen.
     */
    private static Stream<Arguments> countGradeInListParameters() {
        //Arrange
        ArrayList<String> grades = new ArrayList<>();
        Collections.addAll(grades,
                "A", "B", "B", "A", "C", "D", "A");
        ArrayList<String> grades2 = new ArrayList<>();
        Collections.addAll(grades2,
                "B", "D", "D", "A", "C", "C");

        return Stream.of(
                Arguments.of("A", grades, 3),
                Arguments.of("B", grades, 2),
                Arguments.of("C", grades, 1),
                Arguments.of("D", grades, 1),
                Arguments.of("E", grades, 0),
                Arguments.of("F", grades, 0),

                Arguments.of("A", grades2, 1),
                Arguments.of("B", grades2, 1),
                Arguments.of("C", grades2, 2),
                Arguments.of("D", grades2, 2),
                Arguments.of("E", grades2, 0),
                Arguments.of("F", grades2, 0)
        );
    }

    /*
    Parameterisert test for å telle karakter i en liste med karakterer. Merk at denne er veldig generelt definert
    og tilpasses dynamisk for alle argumentene som kommer fra countGradeInListParameters
     */
    @ParameterizedTest(name = "Count of grade {0} is {2} for list {1}")
    @MethodSource("countGradeInListParameters")
    @DisplayName("Count grade in list of grades")
    public void countGradeInList(String grade, ArrayList<String> gradesList, int expectedCount) {

        //Act
        int actualCount = ExamTool.countGradeInList(grade, gradesList);

        //Assert
        assertEquals(expectedCount, actualCount);

    }

}
