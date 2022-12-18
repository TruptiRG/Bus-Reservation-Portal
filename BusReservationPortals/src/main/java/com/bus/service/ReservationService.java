package com.bus.service;

import com.bus.exception.BusException;
import com.bus.exception.ReservationException;
import com.bus.exception.UserException;
import com.bus.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    public Reservation addReservation(Integer busId,Reservation reservation, String key) throws ReservationException, UserException, BusException;
    public Reservation updateReservation(Reservation reservation, String key) throws ReservationException, UserException;
    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, UserException;
    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException, UserException;
    public List<Reservation> viewAllReservation(String key) throws ReservationException, UserException;
    public List<Reservation> getAllReservationByDate(LocalDate date,String key)throws ReservationException, UserException;

}
