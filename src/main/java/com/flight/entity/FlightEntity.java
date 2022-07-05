package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_table")
public class FlightEntity {
	
	@Id
	@Column
	private String Id;
	
	@Column
	private String flightname;
	
	@Column(name = "from_location")
	private String from;

	@Column(name = "to_location")
	private String to;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


}
