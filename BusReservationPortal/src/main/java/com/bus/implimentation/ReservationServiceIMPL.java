package com.bus.implimentation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.ReservationException;
import com.bus.model.Bus;
import com.bus.model.Reservation;
import com.bus.model.Route;
import com.bus.model.User;
import com.bus.repository.ReservationRepo;
import com.bus.service.ReservationService;

@Service
public class ReservationServiceIMPL implements ReservationService{
	
	@Autowired
	private ReservationRepo rRepo;

	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationException {
		// TODO Auto-generated method stub
				
		Reservation addReservation = rRepo.save(reservation); 
		return addReservation;
	}

//	@Override
//	public Reservation updateReservation(Reservation reservation) throws ReservationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
//		// TODO Auto-generated method stub
//		Optional<Reservation> opt = Optional.of(rRepo.findByReservationId(reservationId));
//		if(opt.isPresent()) {
//			Reservation existingResevation = opt.get();
//			rRepo.delete(existingResevation);
//			return existingResevation;
//		}
//		else {
//			throw new ReservationException("Does not exist with ReservationId : "+reservationId);
//		}
//	}
//
//	@Override
//	public Reservation viewReservation(Integer reservationId) throws ReservationException {
//		// TODO Auto-generated method stub
//		Optional<Reservation> opt = Optional.of(rRepo.findByReservationId(reservationId));
//		if(opt.isPresent()) {
//			Reservation reservation = opt.get();
//			return reservation;
//		}
//		else {
//			throw new ReservationException("Not Found");
//		}
////		return rRepo.findByReservationId(reservationId).orElseThrow(()-> new ReservationException("Not Found"));
//	}
//
//	@Override
//	public List<Reservation> viewAllReservation() throws ReservationException {
//		// TODO Auto-generated method stub
//		List<Reservation> resevations = rRepo.findAll();
//		if(resevations.size()==0) {
//			throw new ReservationException("Not Found");
//		}else
//			return resevations;
//		
//	}

//	@Override
//	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException {
//		// TODO Auto-generated method stub
//		List<Reservation> resevations = rRepo.finfByLocalDate(date);
//		if(resevations.size()==0) {
//			throw new ReservationException("Not Found");
//		}else {
//			return resevations;
//		}
//		
//	}

	

}
