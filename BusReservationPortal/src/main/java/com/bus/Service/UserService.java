package com.bus.Service;

import com.bus.Exception.UserException;
import com.bus.Model.User;


public interface UserService {

    public User addUser(User user)throws UserException;
    public User updateUser(User user, String key)throws UserException;
}