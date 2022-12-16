package com.bus.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@Entity
public class Reservation {
	
	private static final @NotNull LocalDate LocalDate = null;

	private static final @NotNull LocalTime LocalTime = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	@NotNull
	private String reservationStatus;
	
	@NotNull
	private String reservationType;
	
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	
	@NotNull
	private String source;
	
	@NotNull
	private String destination;
	
	@OneToOne
	private Bus bus;

	public Reservation(Integer reservationId, @NotNull String reservationStatus, @NotNull String reservationType,
			@NotNull LocalDate reservationDate, @NotNull LocalTime reservationTime, @NotNull String source,
			@NotNull String destination, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}
	
	public Reservation() {
		this.reservationDate=LocalDate.now();
		this.reservationTime=LocalTime.now();
		
	}
	
	

}
