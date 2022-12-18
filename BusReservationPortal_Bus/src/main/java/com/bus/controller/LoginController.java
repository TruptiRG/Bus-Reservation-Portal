package com.bus.controller;

import com.bus.exception.LoginException;
import com.bus.model.LoginDTO;
import com.bus.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginService userLogin;

    @PostMapping("/login")
    public ResponseEntity<String>logInUser(@RequestBody LoginDTO dto) throws LoginException {

        String result= userLogin.logIntoAccount(dto);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

}
