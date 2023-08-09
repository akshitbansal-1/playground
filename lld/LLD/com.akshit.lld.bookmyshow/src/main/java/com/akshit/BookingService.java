package com.akshit;

import com.akshit.dao.SeatDao;

import java.util.List;

public class BookingService {

    SeatDao seatDao;
    BookingService(SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    public void blockSeat(String showId, List<String> seatIds, String userId) {
        for (String seatId: seatIds) {
            this.seatDao.blockSeat(showId, seatId, userId);
        }
    }

    // TODO implement payment
    public boolean bookSeat(String showId, List<String> seatIds, String payment, String userId) {
        // confirm payment
        PaymentStatus paymentStatus = paymentMethodStrategy.getMethod(payment).pay();
        if (paymentStatus.isSuccess) {
            for (String seatId: seatId) {
                this.seatDao.bookSeat(showId, seatId, userId);
            }
        }
        return true;
    }

}
