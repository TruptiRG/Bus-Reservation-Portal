package com.bus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer feedbackid;
    private Integer driverRating;
    private Integer ServiceRating;
    private Integer OverallRating;
    private String comment;
    private LocalDateTime feedbackdate;
    
    @OneToOne
    private  User user;
    
    @OneToOne
    private  Bus bus;


}
