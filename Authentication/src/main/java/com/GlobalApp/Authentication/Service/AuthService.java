package com.GlobalApp.Authentication.Service;

import com.GlobalApp.Authentication.Exception.UserNotFoundException;
import com.GlobalApp.Authentication.Model.User;
import com.GlobalApp.Authentication.Model.UserRequest;
import com.GlobalApp.Authentication.repo.AuthRepo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface AuthService {
    User saveUser(User user);
    Boolean exitsByEmail(UserRequest request);
    public  User forgetPassword(UserRequest request) throws UserNotFoundException;


}

