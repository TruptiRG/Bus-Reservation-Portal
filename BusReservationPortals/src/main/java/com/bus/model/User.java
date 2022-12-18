package com.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userLoginId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;

    @JsonIgnore
    @OneToOne
    private Reservation reservation;
}
