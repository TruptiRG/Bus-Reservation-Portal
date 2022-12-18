package com.bus.service;

import com.bus.model.AdminDTO;

import javax.security.auth.login.LoginException;

public interface AdminService {

    public String logIntoAccount(AdminDTO dto) throws LoginException;

    public String logOutFromAccount(String key) throws LoginException;
}
