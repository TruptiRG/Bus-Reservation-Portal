package com.bus.Service;

import com.bus.Model.LoginDTO;

import javax.security.auth.login.LoginException;

public interface LoginService {

    public String logIntoAccount(LoginDTO dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;
}
