package com.bus.implimentation;

import com.bus.exception.UserException;
import com.bus.model.User;
import com.bus.repository.IUserRepo;
import com.bus.repository.SessionRepo;
import com.bus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private SessionRepo sessionRepo;
    @Override
    public User addUser(User user) throws UserException {
        User user1= userRepo.findByContact(user.getContact());
        if(user1!=null){
            throw new UserException("User Already Exist With Contact No");
        }
        return userRepo.save(user1);
    }

//    @Override
//    public User updateUser(User user, String key) throws UserException {
//        return null;
//    }
//
//    @Override
//    public User deleteUser(Integer userId, String key) throws UserException {
//        return null;
//    }
//
//    @Override
//    public User viewUser(Integer userId, String key) throws UserException {
//        return null;
//    }
//
//    @Override
//    public List<User> viewAllUsers(String key) throws UserException {
//        return null;
//    }
}
