package com.flight.model;

public class Booking {
	
	private String bookingId;
	private String pasengerName;
	private String flightId;
	

	public Booking() {
	
	}
	public Booking(String bookingId, String pasengerName, String flightId) {
		super();
		this.bookingId = bookingId;
		this.pasengerName = pasengerName;
		this.flightId = flightId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getPasengerName() {
		return pasengerName;
	}
	public void setPasengerName(String pasengerName) {
		this.pasengerName = pasengerName;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
}
