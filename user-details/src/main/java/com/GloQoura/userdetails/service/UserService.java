package com.GloQoura.userdetails.service;

import com.GloQoura.userdetails.excepation.UserNameAlreadyExist;
import com.GloQoura.userdetails.excepation.UserNotFound;
import com.GloQoura.userdetails.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDetails addUser(UserDetails userDetails) throws UserNameAlreadyExist;

    UserDetails getSpecificUser(int userId) throws UserNotFound;


    UserDetails updateUser(int uId, UserDetails userDetails) throws UserNotFound;


    String DeleteUser (int uId) throws UserNotFound;

    List<UserDetails> getAllUser();

}
