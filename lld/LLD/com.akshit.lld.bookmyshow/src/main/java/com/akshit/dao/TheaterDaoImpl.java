package com.akshit.dao;

import com.akshit.Location;
import com.akshit.Movie;
import com.akshit.Show;
import com.akshit.Theater;

import java.util.*;
import java.util.stream.Collectors;

public class TheaterDaoImpl implements TheaterDao {

    List<Theater> theaters;

    TheaterDaoImpl() {
        theaters = new ArrayList<>();
    }

    @Override
    public List<Theater> getTheatersByLocation(Location location) {
        return theaters.stream().filter(theater -> theater.getLocation() == location).collect(Collectors.toList());
    }


}
