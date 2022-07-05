package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.exception.BookingNotFoundException;
import com.flight.model.Booking;
import com.flight.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService service;

	@GetMapping("/booking")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Booking> getBooking() {

		return service.getAllBooking();
	}

	@GetMapping("/rest/booking/{bookingId}")
	public Booking getBookingDetails(@PathVariable String bookingId) throws BookingNotFoundException {

		return service.getBookingDetails(bookingId);
	}

	@PostMapping("/rest/booking")
	public String saveBooking(@RequestBody Booking booking) {

		boolean saved = service.saveBooking(booking);

		return "SAVED";
	}

}
