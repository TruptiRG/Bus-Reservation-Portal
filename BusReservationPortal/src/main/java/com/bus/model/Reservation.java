package com.bus.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

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

}
