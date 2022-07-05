package com.flight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.flight.entity.BookingEntity;
import com.flight.model.Booking;
import com.flight.repo.BookingRepository;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingServiceStub {

		@Bean
		BookingService service() {

			return new BookingService();
		}

	}

	@Autowired
	private BookingService service;

	@MockBean
	BookingRepository repo;

	@Test
	public void testGetAllBooking() {

		List<BookingEntity> bookingList = new ArrayList<>();
		bookingList.add(new BookingEntity("J334JJ", "Ed"));

		Mockito.when(repo.findAll()).thenReturn(bookingList);

		List<Booking> returnList = service.getAllBooking();

		assertEquals("J334JJ", returnList.get(0).getBookingId());

	}

}
