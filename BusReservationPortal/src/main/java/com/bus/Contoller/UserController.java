package com.bus.Contoller;

import com.bus.Exception.UserException;
import com.bus.Model.User;
import com.bus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserService uServ;

    @PostMapping("/user")
    public ResponseEntity<User>saveUser(@RequestBody User user) throws UserException {

        User savedUser=uServ.addUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @PutMapping ("/user")
    public ResponseEntity<User>updateUser(@RequestBody User user, @RequestParam(required = false) String key) throws UserException {

        User updateuser=uServ.updateUser(user,key);

        return new ResponseEntity<User>(updateuser, HttpStatus.OK);
    }
}
