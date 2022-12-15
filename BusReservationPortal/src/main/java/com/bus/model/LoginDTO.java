package com.bus.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotNull(message = "Please Enter Valid Contact No")
    private Long contact;

    @NotNull(message = "Please Enter Valid Password")
    private String password;

}
