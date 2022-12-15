package com.bus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userLoginId;

    private String userName;

    @Size(min = 6, message="Password length between 6 to 8 character")
    @Size(max = 10, message = "Password length between 6 to 8 character")
    private String password;

    private String firstName;

    private String lastName;

    private Long contact;

    @Email(message = "Please Enter valid EmailId")
    private String email;

}
