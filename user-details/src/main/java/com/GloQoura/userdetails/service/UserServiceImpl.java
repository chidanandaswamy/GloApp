package com.GloQoura.userdetails.service;

import com.GloQoura.userdetails.excepation.UserNameAlreadyExist;
import com.GloQoura.userdetails.excepation.UserNotFound;
import com.GloQoura.userdetails.model.UserDetails;
import com.GloQoura.userdetails.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userDetailsRepo;

    private UserDetails userDetails;


    @Override
    public UserDetails addUser(UserDetails userDetails) throws UserNameAlreadyExist {

      //  if(userDetailsRepo.findByUserName(userDetails.getUserName()).getUserName().isEmpty())
            userDetails = userDetailsRepo.save(userDetails);
     //   else
      //      throw new UserNameAlreadyExist("User name not available");

        return userDetails;
    }

    @Override
    public UserDetails getSpecificUser(int userId) throws UserNotFound {

        if(userDetailsRepo.findById(userId).isPresent())
            userDetails = userDetailsRepo.findById(userId).get();
        else
            throw new UserNotFound("User Not Found");

        return userDetails;
    }

    @Override
    public UserDetails updateUser(int uId, UserDetails userDetails) {
        Optional<UserDetails> data = userDetailsRepo.findById(uId);
        if(data.isPresent())
                userDetailsRepo.save(userDetails);
        return null;
    }

    @Override
    public String DeleteUser(int uId) throws UserNotFound {

        Optional<UserDetails> data = userDetailsRepo.findById(uId);

        if(data.isPresent())
            userDetailsRepo.deleteById(uId);
        else
            throw new UserNotFound("User Not Found");


        return "User Delete Successfully..";
    }

    @Override
    public List<UserDetails> getAllUser() {
        return userDetailsRepo.findAll();
    }

}
