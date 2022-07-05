package com.flight.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.flight.entity.BookingEntity;

@DataJpaTest
@ActiveProfiles("test")
public class BookingRespositoryTest {

	@Autowired
	private BookingRepository repo;

	@Test
	public void testFindAllBooking() {
		repo.save(new BookingEntity("J334JJ", "Ed"));

		List<BookingEntity> bookingList = new ArrayList<>();
		Iterable<BookingEntity> bookingIerable = repo.findAll();
		bookingIerable.forEach(bookingList::add);

		assertEquals(1, bookingList.size());

		}

}
