package com.bus.implementation;


import com.bus.exception.BusException;
import com.bus.exception.ReservationException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.CurrentSession;
import com.bus.model.Reservation;
import com.bus.model.User;
import com.bus.repository.BusRepo;
import com.bus.repository.ReservationRepo;
import com.bus.repository.SessionRepo;
import com.bus.repository.UserRepo;
import com.bus.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepo rRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private SessionRepo srepo;

    @Autowired
    private UserRepo uRepo;
    @Override
    public Reservation addReservation(Integer busId,Reservation reservation, String key) throws ReservationException, UserException, BusException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }

        User u = uRepo.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User with User Id "+ loggedInUser.getUserId()+" does not exist"));


        Bus b = busRepo.findById(busId).orElseThrow(() -> new BusException("Bus with Id " + busId + " not found"));

        if (!reservation.getSource().equalsIgnoreCase(b.getRouteFrom()) || !reservation.getDestination().equalsIgnoreCase(b.getRouteTo()))
            throw new ReservationException("Bus is not available for this route");

        if (b.getAvailableSeats() <= 0) throw new ReservationException("Seats are not available");


        b.setAvailableSeats(b.getAvailableSeats() - 1);

        reservation.setReservationType("Online");
        reservation.setReservationStatus("Booked");
        reservation.setReservationTime(LocalTime.now());
        reservation.setBus(b);

        u.setReservation(reservation);

        return rRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation, String key) throws ReservationException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }

        Optional<Reservation> opt = rRepo.findById(reservation.getReservationId());

        if(opt.isPresent()) {
            User u = uRepo.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User with User Id "+ loggedInUser.getUserId()+" does not exist"));

            Reservation curr = u.getReservation();

            if (reservation.getDestination() != null) curr.setDestination(reservation.getDestination());
            if (reservation.getReservationDate() != null) curr.setReservationDate(reservation.getReservationDate());
            if (reservation.getReservationStatus() != null) curr.setReservationStatus(reservation.getReservationStatus());
            if (reservation.getReservationTime() != null) curr.setReservationTime(reservation.getReservationTime());
            if (reservation.getReservationType() != null) curr.setReservationType(reservation.getReservationType());
            if (reservation.getSource() != null) curr.setSource(reservation.getSource());

            Reservation updateReservation = rRepo.save(curr);

            u.setReservation(updateReservation);

            return updateReservation;


        }
        else {

            throw new ReservationException("Reservation not found");

        }

    }


    @Override
    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }


        Optional<Reservation> opt = rRepo.findById(reservationId);

        if(opt.isPresent()) {


            Reservation existingReservation = opt.get();
            Optional<User> u = uRepo.findById(loggedInUser.getUserId());

            User currUser = u.get();

            Bus b = busRepo.findById(currUser.getReservation().getBus().getBusId()).orElseThrow(() -> new ReservationException("Bus with Id " + currUser.getReservation().getBus().getBusId() + " not found"));
            b.setAvailableSeats(b.getAvailableSeats()+1);

            currUser.setReservation( null);

            rRepo.delete(existingReservation);

            return existingReservation;

        }
        else {

            throw new ReservationException("Reservation is not present with this Reservation ID :" + reservationId);

        }

    }

    @Override
    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }


        Optional<Reservation> opt = rRepo.findById(reservationId);

        if(opt.isPresent()) {


            if (loggedInUser.getType().equalsIgnoreCase("Admin")) {

                Reservation reservation = opt.get();

                return reservation;
            }
            else {
                User u=uRepo.findById(loggedInUser.getUserId())
                        .orElseThrow(()-> new UserException("User with User Id "+loggedInUser.getUserId()+" does not exist"));
                if(u.getUserLoginId()==loggedInUser.getUserId()) {
                    Reservation reservation = opt.get();

                    return reservation;
                }
                else {
                    throw new UserException("Invalid User details, please login first");
                }
            }
        }
        else {

            throw new ReservationException("Reservation is not present with this Reservation ID :" + reservationId);

        }
    }
    @Override
    public List<Reservation> viewAllReservation(String key) throws ReservationException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }
        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {

            List<Reservation> reservation = rRepo.findAll();


            if(reservation.size() != 0) {

                return reservation;
            }
            else {
                throw new ReservationException("Reservation not found");
            }
        }
        else throw new ReservationException("Access Denied");

}
    @Override
    public List<Reservation> getAllReservationByDate(LocalDate date, String key) throws ReservationException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add reservation");
        }
        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {

            List<Reservation> reservation = rRepo.findAll();

            List<Reservation> reservationByDate = new ArrayList<>();

            if(reservation.size() != 0) {


                for(Reservation s : reservation) {


                    if(date.isEqual(s.getReservationDate())) {

                        reservationByDate.add(s);
                    }

                }


                if(reservationByDate.size() != 0) {

                    return reservationByDate;
                }
                else {
                    throw new ReservationException("No Reservation is available on this Date...");
                }

            }
            else {
                throw new ReservationException("No Reservation is available...!");
            }
        }
        else throw new ReservationException("Access Denied");
    }


}
