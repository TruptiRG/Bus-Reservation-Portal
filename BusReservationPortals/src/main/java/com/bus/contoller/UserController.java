package com.bus.contoller;

import com.bus.exception.UserException;
import com.bus.model.User;
import com.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService uServ;

    @PostMapping("/addUser")
    public ResponseEntity<User>saveUser(@RequestBody User user) throws UserException {

        User savedUser=uServ.addUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @PutMapping ("/updateUser")
    public ResponseEntity<User>updateUser(@RequestBody User user, @RequestParam(required = false) String key) throws UserException {

        User updateuser=uServ.updateUser(user,key);

        return new ResponseEntity<User>(updateuser, HttpStatus.OK);
    }

    @DeleteMapping("deleteUserById/{userId}")
    public ResponseEntity<User>deleteUser(@PathVariable("userId") Integer userId, @RequestParam(required = false) String key) throws UserException {

        User deleteUser=uServ.deleteUser(userId,key);

        return new ResponseEntity<User>(deleteUser, HttpStatus.OK);
    }

    @GetMapping("viewUserById/{userId}")
    public ResponseEntity<User>viewUser(@PathVariable("userId") Integer userId, @RequestParam(required = false) String key) throws UserException {

        User viewUser=uServ.viewUser(userId,key);

        return new ResponseEntity<User>(viewUser, HttpStatus.OK);
    }

    @GetMapping("/viewAllUsers")
    public ResponseEntity<List<User>>viewAllUser(@RequestParam String key) throws UserException {

        List<User> viewAllUser=uServ.viewAllUsers(key);

        return new ResponseEntity<List<User>>(viewAllUser, HttpStatus.OK);
    }
}
