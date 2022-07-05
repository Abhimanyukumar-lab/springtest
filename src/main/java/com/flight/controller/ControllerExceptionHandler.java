package com.flight.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.flight.exception.BookingNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(BookingNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleBookingNotFound(BookingNotFoundException exception, HttpServletRequest request) {
		
		return exception.getMessage();
	}
	
}
