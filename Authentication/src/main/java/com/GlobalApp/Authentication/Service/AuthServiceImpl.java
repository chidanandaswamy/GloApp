package com.GlobalApp.Authentication.Service;

import com.GlobalApp.Authentication.Exception.UserNotFoundException;
import com.GlobalApp.Authentication.Model.User;
import com.GlobalApp.Authentication.Model.UserRequest;
import com.GlobalApp.Authentication.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthRepo repo;

    //save method
    @Override
    public User saveUser(User user) {

        //encode password


        return repo.save(user);
    }

    @Override
    public Boolean exitsByEmail(UserRequest request)

    {
        User user=repo.findById(request.getEmail()).get();
        if(user==null) {
            return false;
        }
        else {

            if(user.getPassword().equals(request.getPassword())) {
                return true;
            }
            return false;

        }
    }
    public  User forgetPassword(UserRequest request) throws UserNotFoundException {
        User user= repo.findById(request.getEmail()).get();
        if(user==null) {
            throw new UserNotFoundException();

        }else {
            user.setPassword(request.getPassword());
            return repo.save(user);
        }
    }
}
