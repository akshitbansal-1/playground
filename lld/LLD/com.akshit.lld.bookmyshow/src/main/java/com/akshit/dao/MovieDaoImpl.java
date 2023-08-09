package com.akshit.dao;

import com.akshit.Location;
import com.akshit.Movie;
import com.akshit.Show;
import com.akshit.Theater;

import java.util.*;
import java.util.stream.Collectors;

public class MovieDaoImpl implements MovieDao {


    List<Movie> movies;

    TheaterDao theaterDao;

    MovieDaoImpl(TheaterDao theaterDao) {
        this.theaterDao = theaterDao;
        movies = new ArrayList<>();
    }

    @Override
    public List<Movie> getMoviesByLocation(Location location) {
        Optional<Set<Movie>> movies = theaterDao.getTheatersByLocation(location).stream().filter(theater -> theater.getLocation() == location).map(Theater::getMovies)
                .reduce((movies1, movies2) -> {
                    HashSet<Movie> hashSet = new HashSet<>();
                    hashSet.addAll(movies1);
                    hashSet.addAll(movies2);
                    return hashSet;
                });
        return movies.map(ArrayList::new).orElseGet(ArrayList::new);
    }

    @Override
    public Movie getMovieDetails(String movieId) {
        return movies.stream().filter(movie -> Objects.equals(movie.getId(), movieId)).findFirst().get();
    }

}
