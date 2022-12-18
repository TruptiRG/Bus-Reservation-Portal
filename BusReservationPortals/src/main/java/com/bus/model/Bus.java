package com.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer busId;
    private String busName;
    private String busType;
    private String routeFrom;
    private String routeTo;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private Integer seats;
    private Integer availableSeats;

    @JsonIgnore
    @ManyToOne
    private Route route;

    public Bus(Integer busId, String busName, String busType, String routeFrom, String routeTo, LocalTime arrivalTime, LocalTime departureTime, Integer seats, Integer availableSeats) {
        this.busId = busId;
        this.busName = busName;
        this.busType = busType;
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.seats = seats;
        this.availableSeats = availableSeats;

    }

    public Bus() {
        arrivalTime=LocalTime.now();
        departureTime=LocalTime.now().plusMinutes(15);
    }
}
