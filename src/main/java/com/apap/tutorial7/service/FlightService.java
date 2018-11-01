package com.apap.tutorial7.service;


import com.apap.tutorial7.model.FlightModel;

import java.util.List;
import java.util.Optional;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    
    void deleteByFlightNumber(String flightNumber);

    FlightModel getFlightDetailByFlightNumber(String flightNumber);

    FlightModel getFlightDetailById(long id);

    void deleteFlight(FlightModel flight);

    List<FlightModel> getAll();
}