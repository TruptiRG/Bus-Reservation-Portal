package com.bus.service;

import com.bus.exception.LoginException;
import com.bus.model.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    public String logIntoAccount(LoginDTO dto) throws LoginException;
//    public String logOutFromAccount(String key) throws LoginException;
}
