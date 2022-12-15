package com.bus.controller;

import com.bus.exception.UserException;
import com.bus.model.User;
import com.bus.repository.IUserRepo;
import com.bus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws UserException {
            User user1= iUserService.addUser(user);
            return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
}
