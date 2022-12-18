package com.bus.implimentation;

import com.bus.exception.LoginException;
import com.bus.model.CurrentUserSession;
import com.bus.model.LoginDTO;
import com.bus.model.User;
import com.bus.repository.IUserRepo;
import com.bus.repository.SessionRepo;
import com.bus.service.LoginService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public String logIntoAccount(LoginDTO dto) throws LoginException {

        User user= userRepo.findByContact(dto.getContact());

        if(user==null){
            throw new LoginException("Please Enter Valid Contact No.");
        }

        Optional<CurrentUserSession> validUser= sessionRepo.findById(user.getUserLoginId());
        if(validUser.isPresent()){
            throw new LoginException("User already Logged In with this number");
        }
        if(user.getPassword().equals(dto.getPassword())){
            String key= RandomString.make(4);
            CurrentUserSession currentUserSession= new CurrentUserSession(user.getUserLoginId(),key, LocalDateTime.now());
            sessionRepo.save(currentUserSession);
            return currentUserSession.toString();
        }
        else{
            throw new LoginException("Please Enter Valid Password");
        }
    }

//    @Override
//    public String logOutFromAccount(String key) throws LoginException {
//        return null;
//    }
}
