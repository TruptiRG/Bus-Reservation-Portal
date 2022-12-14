package com.bus.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer>{
	
	public Reservation findByReservationId(Integer Id);

}
