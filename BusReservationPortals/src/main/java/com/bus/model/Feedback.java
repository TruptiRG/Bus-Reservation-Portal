package com.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedBackId;

//	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Feedback should be length between min 1 and max 10 ")
    private Integer driverRating ;

    //	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Feedback should be length between min 1 and max 10 ")
    private Integer serviceRating ;
    //
//	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Empname should be length between min 1 and max 10 ")
    private Integer overAllRating;

    //@NotNull(message="comment should not be null")
    private String comment;

    @JsonIgnore
    @OneToOne
    private User user;

    @JsonIgnore
    @OneToOne
    private Bus bus;


}
