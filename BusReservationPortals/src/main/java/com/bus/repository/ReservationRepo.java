package com.bus.repository;

import com.bus.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

//    public Reservation findByReservationId(Integer Id);
}
