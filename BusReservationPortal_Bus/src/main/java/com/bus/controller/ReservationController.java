package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/addReservation")
	public ResponseEntity<Reservation> addReservationHandler(@RequestBody Reservation reservation) throws ReservationException{
		
		Reservation addReservation = reservationService.addReservation(reservation);
		return new ResponseEntity<Reservation>(addReservation,HttpStatus.OK);
	}
	
	@PutMapping("/updateReservation")
	public ResponseEntity<Reservation> updateReservationHandler(@RequestBody Reservation reservation) throws ReservationException{
		Reservation updateReservation = reservationService.updateReservation(reservation);
		return new ResponseEntity<Reservation>(updateReservation,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteReservation/{reservationId}")
	public ResponseEntity<Reservation> deleteReservationHandler(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		Reservation deleteReservation = reservationService.deleteReservation(reservationId);
		return new ResponseEntity<Reservation>(deleteReservation,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/viewReservation/{reservationId}")
	public ResponseEntity<List<Reservation>> viewReservationHandler(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		List<Reservation> reservations = (List<Reservation>) reservationService.viewReservation(reservationId);
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllReservation")
	public ResponseEntity<List<Reservation>> viewAllReservationHandeler() throws ReservationException{
		List<Reservation> reservations = reservationService.viewAllReservation();
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	
//	public ResponseEntity<List<Reservation>> getAllResrvation()

	
}
