package com.flight.repo;

import org.springframework.data.repository.CrudRepository;

import com.flight.entity.FlightEntity;

public interface FlightRepository extends CrudRepository<FlightEntity, String>{

}
