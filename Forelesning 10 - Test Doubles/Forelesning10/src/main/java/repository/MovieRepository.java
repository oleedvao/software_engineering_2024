package repository;

import model.Movie;

public interface MovieRepository {

    public Movie getMovieByTitle(String title);

}
