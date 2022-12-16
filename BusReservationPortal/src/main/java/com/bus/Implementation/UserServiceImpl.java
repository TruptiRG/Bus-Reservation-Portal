package com.bus.Implementation;

import com.bus.Exception.UserException;
import com.bus.Model.CurrentSession;
import com.bus.Model.User;
import com.bus.Repository.SessionRepo;
import com.bus.Repository.UserRepo;
import com.bus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
