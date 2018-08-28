package com.zhuochen.um.backend.controller;

import com.zhuochen.um.adapter.web.ResponseMessageWrapper;
import com.zhuochen.um.adapter.web.login.LoginRequest;
import com.zhuochen.um.adapter.web.login.LoginResponse;
import com.zhuochen.um.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseMessageWrapper<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @GetMapping(value = "/logout")
    public ResponseMessageWrapper<LoginResponse> logout() {
        return loginService.logout();
    }
}
