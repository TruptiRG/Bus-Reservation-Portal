package com.bus.implementation;

import com.bus.exception.UserException;
import com.bus.model.CurrentSession;
import com.bus.model.User;
import com.bus.repository.SessionRepo;
import com.bus.repository.UserRepo;
import com.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo uRepo;

    @Autowired
    public SessionRepo sRepo;
    @Override
    public User addUser(User user) throws UserException {

        User existing= uRepo.findBycontact(user.getContact());

        if (existing!=null){
            throw new UserException("User Already Register by Conatct No");
        }else{
            return uRepo.save(user);
        }

    }

    @Override
    public User updateUser(User user, String key) throws UserException {
        CurrentSession loggedInUser= sRepo.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to update a customer");
        }

        if(user.getUserloginId() == loggedInUser.getUserId()) {
            //If LoggedInUser id is same as the id of supplied Customer which we want to update
            return uRepo.save(user);
        }
        else
            throw new UserException("Invalid Customer Details, please login first");
    }

    @Override
    public User deleteUser(Integer userId, String key) throws UserException {
        CurrentSession loggedInUser= sRepo.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to update a customer");
        }

        User u1= uRepo.findById(userId).orElseThrow(()-> new UserException(userId+" UserId Not Exist"));

        if(u1.getUserloginId() == loggedInUser.getUserId()) {

             uRepo.delete(u1);
             sRepo.delete(loggedInUser);
             return u1;
        }
        else {
            throw new UserException("Access Denied");
        }
    }

    @Override
    public User viewUser(Integer userId, String key) throws UserException {
        CurrentSession loggedInUser= sRepo.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to update a customer");
        }

        User u1= uRepo.findById(userId).orElseThrow(()-> new UserException(userId+" UserId Not Exist"));

        if(u1.getUserloginId() == loggedInUser.getUserId()) {
            return u1;
        }
        else {
            throw new UserException("User Not Found");
        }
    }

    @Override
    public List<User> viewAllUsers(String key) throws UserException {

        CurrentSession loggedInUser= sRepo.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to update a customer");
        }

        List<User> use=uRepo.findAll();
        if(use.size()!=0) {
            return use;
        }else {
            throw new UserException("No User Found.");
        }

    }
}
