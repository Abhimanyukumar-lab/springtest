package com.flight.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.flight.model.Booking;
import com.flight.service.BookingService;

@WebMvcTest(BookingRestController.class)
public class BookingRestControllerTest {

	@MockBean
	private BookingService service;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetBooking() throws Exception {

		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(new Booking("J334JJ", "Ed", "QA01A"));
		Mockito.when(service.getAllBooking()).thenReturn(bookingList);
		mvc.perform(get("/booking")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}

	@Test
	public void testSaveBooking() throws Exception {

		Mockito.when(service.saveBooking(any())).thenReturn(true);		
		
		String bookingDetails = "{\r\n"
				+ "        \"bookingId\": \"ACCC900\",\r\n"
				+ "        \"pasengerName\": \"Ed\",\r\n"
				+ "        \"flightName\": \"AA01\"\r\n"
				+ "    }";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/booking").contentType(MediaType.APPLICATION_JSON).content(bookingDetails);
		
		mvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string("SAVED"));
		
	}

}
