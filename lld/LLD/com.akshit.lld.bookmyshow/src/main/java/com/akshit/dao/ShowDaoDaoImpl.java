package com.akshit.dao;

import com.akshit.*;

import java.util.*;
import java.util.stream.Collectors;

public class ShowDaoDaoImpl implements ShowDao {

    List<Show> shows;

    ShowDaoDaoImpl() {
        shows = new ArrayList<>();
    }

    @Override
    public List<Show> getShowsOfMovie(String movieId) {
        return shows.stream().filter(show -> show.getMovieId().equals(movieId)).collect(Collectors.toList());
    }

    @Override
    public void updateSeatStatus(String seatId, User user) {

    }
}
