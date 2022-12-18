package com.bus.implementation;

import com.bus.exception.UserException;
import com.bus.model.CurrentSession;
import com.bus.model.Reservation;
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

        User curr=uRepo.findById(user.getUserLoginId())
                .orElseThrow(()-> new UserException("User with User Id "+user.getUserLoginId()+" does not exist"));
        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {
            if (user.getContact() != null) curr.setContact(user.getContact());
            if (user.getEmail() != null) curr.setEmail(user.getEmail());
            if (user.getFirstName() != null) curr.setFirstName(user.getFirstName());
            if (user.getLastName() != null) curr.setLastName(user.getLastName());
            if (user.getPassword() != null) curr.setPassword(user.getPassword());
            if (user.getUserName() != null) curr.setUserName(user.getUserName());
            User saved = uRepo.save(curr);
            return saved;
        }
        if(user.getUserLoginId()==loggedInUser.getUserId()) {
            if (user.getContact() != null) curr.setContact(user.getContact());
            if (user.getEmail() != null) curr.setEmail(user.getEmail());
            if (user.getFirstName() != null) curr.setFirstName(user.getFirstName());
            if (user.getLastName() != null) curr.setLastName(user.getLastName());
            if (user.getPassword() != null) curr.setPassword(user.getPassword());
            if (user.getUserName() != null) curr.setUserName(user.getUserName());

            User saved = uRepo.save(curr);

            return saved;

        }
        else throw new UserException("Access denied.");
    }

    @Override
    public User deleteUser(Integer userId, String key) throws UserException {
        CurrentSession loggedInUser= sRepo.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to Delete a customer");
        }

        User u1= uRepo.findById(userId).orElseThrow(()-> new UserException(userId+" UserId Not Exist"));

        if(u1.getUserLoginId() == loggedInUser.getUserId()) {

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

        if(u1.getUserLoginId() == loggedInUser.getUserId()) {
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
