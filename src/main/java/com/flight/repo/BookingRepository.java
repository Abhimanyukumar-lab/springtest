package com.flight.repo;

import org.springframework.data.repository.CrudRepository;

import com.flight.entity.BookingEntity;

public interface BookingRepository extends CrudRepository<BookingEntity, String>{

}
