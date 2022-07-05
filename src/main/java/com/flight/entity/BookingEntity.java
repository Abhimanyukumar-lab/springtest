package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking_table")
public class BookingEntity {
	
	@Id
	@Column
	private String bookingId;
	
	@Column
	private String pasengerName;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private FlightEntity flight;

	
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

	

	public FlightEntity getFlight() {
		return flight;
	}

	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}

	public BookingEntity() {
		super();
	}

	public BookingEntity(String bookingId, String pasengerName) {
		super();
		this.bookingId = bookingId;
		this.pasengerName = pasengerName;
	}
	
	

}
