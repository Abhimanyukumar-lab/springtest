package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.FlightEntity;
import com.flight.model.Flight;
import com.flight.repo.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepo;

	
	public boolean saveFlight(Flight flight) {

		FlightEntity entity = new FlightEntity();

		entity.setId(flight.getId());
		entity.setFlightname(flight.getFlightName());
		entity.setFrom(flight.getFrom());
		entity.setTo(flight.getTo());

		flightRepo.save(entity);

		return true;
	}

}
