package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.BookingEntity;
import com.flight.entity.FlightEntity;
import com.flight.exception.BookingNotFoundException;
import com.flight.model.Booking;
import com.flight.repo.BookingRepository;
import com.flight.repo.FlightRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;

	@Autowired
	FlightRepository flightRepo;

	public List<Booking> getAllBooking() {

		Iterable<BookingEntity> bookingList = bookingRepo.findAll();
		List<Booking> list = new ArrayList<>();

		for (BookingEntity entity : bookingList) {
			Booking booking = new Booking();

			booking.setBookingId(entity.getBookingId());
			booking.setFlightId(entity.getFlight().getId());
			booking.setPasengerName(entity.getPasengerName());

			list.add(booking);

		}
		return list;
	}

	public Booking getBookingDetails(String bookingId) throws BookingNotFoundException {

		Optional<BookingEntity> optionalBooking = bookingRepo.findById(bookingId);

		Booking booking = new Booking();
		if (optionalBooking.isPresent()) {

			booking.setBookingId(optionalBooking.get().getBookingId());
			booking.setFlightId(optionalBooking.get().getFlight().getId());
			booking.setPasengerName(optionalBooking.get().getPasengerName());

		} else {
			throw new BookingNotFoundException("No booking found for this bookingid " + bookingId);
		}
		return booking;
	}

	public boolean saveBooking(Booking booking) {

		// Get flight details
		Optional<FlightEntity> flight = flightRepo.findById(booking.getFlightId());

		BookingEntity entity = new BookingEntity();

		entity.setBookingId(booking.getBookingId());
		entity.setFlight(flight.get());
		entity.setPasengerName(booking.getPasengerName());

		bookingRepo.save(entity);

		return true;
	}

}
