package com.bus.contoller;

import com.bus.model.AdminDTO;
import com.bus.service.AdminService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    private AdminService lService;

    @PostMapping("/login")
    public ResponseEntity<String> adminLoginHandler(@RequestBody AdminDTO dto) throws LoginException {
        String msg=lService.logIntoAccount(dto);
        return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> adminLogoutHandler(@RequestParam String key) throws LoginException{
        String msg=lService.logOutFromAccount(key);
        return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
    }

}
