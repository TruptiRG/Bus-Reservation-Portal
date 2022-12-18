package com.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;

    private String reservationStatus;

    private String reservationType;

    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String source;
    private String destination;

    @JsonIgnore
    @OneToOne
    private Bus bus;

    public Reservation() {
        reservationDate=LocalDate.now();
        reservationTime=LocalTime.now();
    }

    public Reservation(Integer reservationId, String reservationStatus, String reservationType, LocalDate reservationDate, LocalTime reservationTime) {
        this.reservationId = reservationId;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }
}
