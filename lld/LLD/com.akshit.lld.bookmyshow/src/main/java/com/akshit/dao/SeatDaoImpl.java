package com.akshit.dao;

import com.akshit.*;

import java.util.*;
import java.util.stream.Collectors;

public class SeatDaoImpl implements SeatDao {


    List<Seat> seats;

    List<ShowSeat> showSeats;


    SeatMonitor seatMonitor;

    SeatDaoImpl(SeatMonitor seatMonitor) {
        this.seatMonitor = seatMonitor;
    }

    @Override
    public List<ShowSeat> getSeats(String hallId, String showId) {
        Seat seat = seats.stream().filter(s -> s.getHallId().equals(hallId)).findFirst().get();
        return showSeats.stream().filter(showSeat -> showSeat.getSeatId().equals(seat.getSeatId()) && showSeat.getShowId().equals(showId))
                .collect(Collectors.toList());
    }

    @Override
    public void blockSeat(String showId, String seatId, String userId) {
        Seat seat = seats.stream().filter(s -> s.getHallId().equals(showId)).findFirst().get();
        ShowSeat ss = showSeats.stream().filter(showSeat -> showSeat.getSeatId().equals(seatId) && showSeat.getShowId().equals(showId))
                .findFirst().get();
        if (ss.getSeatState() == SeatState.BOOKED) {
            throw new IllegalStateException("Seat already booked. Choose another");
        }
        ss.setSeatState(SeatState.BOOKED);
        this.seatMonitor.registerSeatTimer(ss, userId);
    }

    @Override
    public boolean bookSeat(String hallId, String showId, String userId) {
        Seat seat = seats.stream().filter(s -> s.getHallId().equals(hallId)).findFirst().get();
        ShowSeat ss = showSeats.stream().filter(showSeat -> showSeat.getSeatId().equals(seat.getSeatId()) && showSeat.getShowId().equals(showId))
                .findFirst().get();
        if (ss.getSeatState() == SeatState.BOOKED) {
            throw new IllegalStateException("Seat already booked. Choose another");
        }
        ss.setSeatState(SeatState.BOOKED);
        this.seatMonitor.registerSeatTimer(ss, userId);
    }
}
