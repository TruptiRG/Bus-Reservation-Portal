package com.bus.service;

import com.bus.exception.ReservationException;
import com.bus.model.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(Reservation reservation) throws ReservationException;
	public Reservation uudateReservation(Reservation reservation) throws ReservationException;
	
	

}
