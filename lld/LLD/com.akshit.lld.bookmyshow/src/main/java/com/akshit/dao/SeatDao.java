package com.akshit.dao;

import com.akshit.Location;
import com.akshit.Movie;
import com.akshit.Seat;
import com.akshit.ShowSeat;

import java.util.List;

public interface SeatDao {

    public List<ShowSeat> getSeats(String hallId, String showId);

    public void blockSeat(String showId, String seatId, String userId);

    public boolean bookSeat(String hallId, String showId, String userId);

}
