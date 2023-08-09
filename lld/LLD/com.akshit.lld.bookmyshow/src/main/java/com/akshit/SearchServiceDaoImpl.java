package com.akshit;

import java.util.*;
import java.util.stream.Collectors;

public class SearchServiceDaoImpl implements SearchServiceDao{

    List<Theater> theaters;

    List<Movie> movies;

    List<Show> shows;

    SearchServiceDaoImpl() {
        theaters = new ArrayList<>();
        movies = new ArrayList<>();
        shows = new ArrayList<>();
    }

    @Override
    public List<Movie> getMoviesByLocation(Location location) {
        Optional<Set<Movie>> movies = theaters.stream().filter(theater -> theater.location == location).map(Theater::getMovies)
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
        return movies.stream().filter(movie -> Objects.equals(movie.id, movieId)).findFirst().get();
    }

    @Override
    public List<Theater> getTheatersByLocation(Location location) {
        return theaters.stream().filter(theater -> theater.location == location).collect(Collectors.toList());
    }

    @Override
    public List<Show> getShowsOfTheater(String theaterId) {
        return shows.stream().filter(show -> show.theaterId.equals(theaterId)).collect(Collectors.toList());
    }

    @Override
    public List<Show> getShowsOfMovie(String movieId) {
        return shows.stream().filter(show -> show.movieId.equals(movieId)).collect(Collectors.toList());
    }
}
