package com.akshit;

import java.util.*;
import java.util.stream.Collectors;

public class SearchService {

    SearchServiceDao searchServiceDao;

    public SearchService(SearchServiceDao searchServiceDao) {
        this.searchServiceDao = searchServiceDao;
    }

    public List<Theater> listTheaters(Location location) {
        return searchServiceDao.getTheatersByLocation(location);
    }

    public List<Movie> listMovies(Location location) {
        return searchServiceDao.getMoviesByLocation(location);
    }

    public Movie getMoviesData(String movieId) {
        return getMoviesData(movieId);
    }

    public List<Show> listShows(String movieId) {
        return searchServiceDao.getShowsOfMovie(movieId);
    }

    public List<Show> listShows(String movieId, String theaterId) {
        return searchServiceDao.getShowsOfMovie(movieId).stream().filter(show -> show.theaterId.equals(theaterId)).collect(Collectors.toList());
    }

}
