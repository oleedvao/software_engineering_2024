package model;

import repository.MovieRepository;

public class MovieDescriber {

    private MovieRepository movieRepository;

    public MovieDescriber(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String describeMovie(String title) {
        Movie movie = movieRepository.getMovieByTitle(title);

        if (movie == null) {
            return "The movie could not be found.";
        }
        return "The movie " + movie.getTitle() + " has a runtime of " +
                movie.getRuntimeInMinutes() + " minutes.";
    }

}
