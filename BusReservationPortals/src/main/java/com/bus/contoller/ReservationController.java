package com.bus.contoller;

import com.bus.exception.BusException;
import com.bus.exception.ReservationException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.Reservation;
import com.bus.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> addReservationHandler(@PathVariable Integer busId,@RequestBody Reservation reservation,@RequestParam String key) throws ReservationException, UserException, BusException {

        Reservation addReservation = reservationService.addReservation(busId,reservation,key);
        return new ResponseEntity<Reservation>(addReservation, HttpStatus.OK);
    }

    @PutMapping("/updateReservation")
    public ResponseEntity<Reservation> updateReservationHandler(@RequestBody Reservation reservation,@RequestParam String key) throws ReservationException, UserException {
        Reservation updateReservation = reservationService.updateReservation(reservation,key);
        return new ResponseEntity<Reservation>(updateReservation,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/deleteReservation/{reservationId}")
    public ResponseEntity<Reservation> deleteReservationHandler(@PathVariable("reservationId") Integer reservationId,@RequestParam String key) throws ReservationException, UserException {
        Reservation deleteReservation = reservationService.deleteReservation(reservationId,key);
        return new ResponseEntity<Reservation>(deleteReservation,HttpStatus.OK);
    }


    @GetMapping("/viewReservation/{reservationId}")
    public ResponseEntity<Reservation> viewReservationHandler(@PathVariable("reservationId") Integer reservationId,@RequestParam String key) throws ReservationException, UserException {

        return new ResponseEntity<Reservation>(reservationService.viewReservation(reservationId,key),HttpStatus.FOUND);
    }

    @GetMapping("/viewAllReservation")
    public ResponseEntity<List<Reservation>> viewAllReservationHandeler(@RequestParam String key) throws ReservationException, UserException {

        return new ResponseEntity<List<Reservation>>(reservationService.viewAllReservation(key),HttpStatus.FOUND);
    }

}
