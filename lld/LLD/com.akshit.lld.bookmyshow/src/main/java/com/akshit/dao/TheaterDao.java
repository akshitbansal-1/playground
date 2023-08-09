package com.akshit.dao;

import com.akshit.Location;
import com.akshit.Movie;
import com.akshit.Show;
import com.akshit.Theater;

import java.util.List;

public interface TheaterDao {

    public List<Theater> getTheatersByLocation(Location location);
}
