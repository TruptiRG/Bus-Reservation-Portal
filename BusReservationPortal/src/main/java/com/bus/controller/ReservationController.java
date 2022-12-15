package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.exception.ReservationException;
import com.bus.model.Reservation;
import com.bus.service.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/bus")
public class ReservationController {
	
 //Nikhil
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> addReservationHandler(@RequestBody Reservation reservation) throws ReservationException{
		
		Reservation addReservation = reservationService.addReservation(reservation);
		return new ResponseEntity<Reservation>(addReservation,HttpStatus.OK);
	}
	
}
