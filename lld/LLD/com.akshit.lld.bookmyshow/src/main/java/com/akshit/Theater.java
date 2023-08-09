package com.akshit;

import java.util.*;

public class Theater {

    String theaterId;

    List<Hall> hallList;

    Location location;

    Map<String, Movie> movieIdToMovieMap;

    public Set<Movie> getMovies() {
        return new HashSet<>(movieIdToMovieMap.values());
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return theaterId;
    }
}
