package com.bus.implementation;

import com.bus.model.Admin;
import com.bus.model.AdminDTO;
import com.bus.model.CurrentSession;
import com.bus.repository.SessionRepo;
import com.bus.service.AdminService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SessionRepo sRepo;

    @Override
    public String logIntoAccount(AdminDTO dto) throws LoginException {

        Admin adm=new Admin();
        if(!adm.username.equalsIgnoreCase(dto.getUsername())) {
            throw new LoginException("Please Enter a valid Username");
        }
        Optional<CurrentSession> validUserSessionOpt =sRepo.findById(adm.id);
        if(validUserSessionOpt.isPresent()) {
            throw new LoginException("Admin already Logged in with this Username");
        }
        if(adm.password.equals(dto.getPassword())) {
            String key= RandomString.make(6);
            CurrentSession currentUserSession=new CurrentSession(adm.id,"ADMIN",key, LocalDateTime.now());
            sRepo.save(currentUserSession);
            return currentUserSession.toString();
        }else {
            throw new LoginException("Please Enter a valid Password");
        }
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
        CurrentSession validUserSession=sRepo.findByUuid(key);

        if(validUserSession==null) {
            throw new LoginException("Admin not logged in with this Username.");
        }
        sRepo.delete(validUserSession);
        return "Logged out successfully";
    }
}
