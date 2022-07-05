package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.Flight;
import com.flight.service.FlightService;

@RestController
public class FlightRestController {

	@Autowired
	private FlightService service;

	@GetMapping("/flight")
	public Flight getFlights() {

		Flight flight = new Flight();
		return flight;
	}

	@PostMapping("/rest/flight")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveFlight(@RequestBody Flight flight) {

		boolean saved = service.saveFlight(flight);

		return "SAVED";
	}

}
