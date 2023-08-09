package com.akshit.dao;

import com.akshit.*;

import java.util.List;

public interface ShowDao {
    public List<Show> getShowsOfMovie(String movieId);

    public void updateSeatStatus(String seatId, User user);
}
