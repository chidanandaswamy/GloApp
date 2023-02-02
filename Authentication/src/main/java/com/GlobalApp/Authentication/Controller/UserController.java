package com.GlobalApp.Authentication.Controller;

import com.GlobalApp.Authentication.Exception.UserNotFoundException;
import com.GlobalApp.Authentication.Model.User;
import com.GlobalApp.Authentication.Model.UserRequest;
import com.GlobalApp.Authentication.Service.AuthServiceImpl;
import com.GlobalApp.Authentication.Utile.JwtUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthServiceImpl service;
    @Autowired
    private JwtUtil util;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser (@RequestBody User user){
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequest request){
        if(service.exitsByEmail(request)) {
            String token =util.generateToken(request.getEmail());
            return new ResponseEntity(token,HttpStatus.OK);
        }
        return new ResponseEntity<String>("Please enter valid Email and Password",HttpStatus.NOT_FOUND);

    }
    @PostMapping("/resetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody UserRequest request){
        try {
            return new ResponseEntity<>(service.forgetPassword(request),HttpStatus.OK);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity<>("Password is Reset",HttpStatus.NOT_FOUND);
        }


    }
}
