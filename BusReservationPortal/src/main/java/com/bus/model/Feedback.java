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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    
    @NotNull(message = "Driver Rating should not be Empty")
    @Size(min = 0,max = 10,message = "Rating Should be Min  0 and Max 10")
    private Integer driverRating;
    
    @NotNull(message = "Service Rating should not be Empty")
    @Size(min = 0,max = 10,message = "Rating Should be Min  0 and Max 10")
    private Integer ServiceRating;
    
    @NotNull(message = "Overall Rating should not be Empty")
    @Size(min = 0,max = 10,message = "Rating Should be Min  0 and Max 10")
    private Integer OverallRating;
    
    @NotNull(message = "Comment should not be Empty")
    private String comment;
    
    private String feedbackdate;
    
    @OneToOne
    private  User user;
    
    @OneToOne
    private  Bus bus;


}
