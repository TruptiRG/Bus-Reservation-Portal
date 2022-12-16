package com.bus.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer>{
	
	public Reservation findByReservationId(Integer Id);
	public List<Reservation> finfByLocalDate(LocalDate date);

}
