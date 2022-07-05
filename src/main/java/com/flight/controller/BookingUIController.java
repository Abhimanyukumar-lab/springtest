package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flight.exception.BookingNotFoundException;
import com.flight.model.Booking;
import com.flight.service.BookingService;

@Controller
public class BookingUIController {

	@Autowired
	private BookingService service;
	
	@GetMapping("/")
	public String getLandingPage() {

		return "index";
	}
	
	
	@GetMapping("/booking/{bookingId}")
	public String getBookingDetails(@PathVariable String bookingId, Model model) throws BookingNotFoundException {

		Booking booking  = service.getBookingDetails(bookingId);
		model.addAttribute("booking", booking);
		return "bookingDetails";
	}
	
	
	@GetMapping("/saveBooking")
	public String getSaveBooking() {

		return "saveBooking";
	}
	
	@PostMapping("/saveBooking")
	public String saveBooking(Booking booking, Model model) {

		boolean saved = service.saveBooking(booking);

		model.addAttribute("message", true);
		
		return "saveBooking";
	}

	
}
