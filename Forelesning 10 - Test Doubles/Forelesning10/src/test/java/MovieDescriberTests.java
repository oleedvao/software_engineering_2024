import model.Movie;
import model.MovieDescriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
public class MovieDescriberTests {

    @Mock
    MovieRepository mockMovieRepo;

    @Mock
    Movie mockMovie;

    @Test
    @DisplayName("Describe movie")
    public void describeMovie() {

        MovieDescriber movieDescriber = new MovieDescriber(mockMovieRepo);
        Mockito.when(mockMovieRepo.getMovieByTitle("Fight Club")).thenReturn(mockMovie);
        Mockito.when(mockMovie.getTitle()).thenReturn("Fight Club");
        Mockito.when(mockMovie.getRuntimeInMinutes()).thenReturn(139);

        String result = movieDescriber.describeMovie("Fight Club");

        String expected = "The movie Fight Club has a runtime of 139 minutes.";
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Describe movie not found")
    public void describeMovieNotFound() {
        MovieDescriber movieDescriber = new MovieDescriber(mockMovieRepo);
        Mockito.when(movieDescriber.describeMovie(Mockito.anyString())).thenReturn(null);

        String result = movieDescriber.describeMovie("Bingus");

        Assertions.assertEquals("The movie could not be found.", result);
    }

}
