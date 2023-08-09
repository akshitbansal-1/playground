package com.akshit;

public class Show {

    String theaterId;

    String hallId;

    String id;

    String movieId;

    long timeStart;

    long timeEnd;

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Show(String theaterId, String hallId, String id, String movieId, long timeStart, long timeEnd) {
        this.theaterId = theaterId;
        this.hallId = hallId;
        this.id = id;
        this.movieId = movieId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}
