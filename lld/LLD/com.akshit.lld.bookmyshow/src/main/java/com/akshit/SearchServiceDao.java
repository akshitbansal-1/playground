package com.akshit;

import java.util.List;

public interface SearchServiceDao {

    public List<Movie> getMoviesByLocation(Location location);

    public Movie getMovieDetails(String movieId);

    public List<Theater> getTheatersByLocation(Location location);

    public List<Show> getShowsOfTheater(String theaterId);

    public List<Show> getShowsOfMovie(String movieId);
}
