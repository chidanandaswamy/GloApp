package com.GloQoura.userdetails.controller;

import com.GloQoura.userdetails.excepation.UserNameAlreadyExist;
import com.GloQoura.userdetails.excepation.UserNotFound;
import com.GloQoura.userdetails.model.UserDetails;
import com.GloQoura.userdetails.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userservice")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private ResponseEntity<?> responseEntity;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserDetails userDetails) throws UserNameAlreadyExist {

        try {

            responseEntity = new ResponseEntity<UserDetails>(userService.addUser(userDetails), HttpStatus.CREATED);

        }catch(UserNameAlreadyExist e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable("id") int userId) throws UserNotFound {

        try {

            responseEntity = new ResponseEntity<>(userService.getSpecificUser(userId), HttpStatus.CREATED);

        } catch (UserNotFound e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int userId) throws UserNotFound {

        try {

            responseEntity = new ResponseEntity<>(userService.DeleteUser(userId), HttpStatus.CREATED);

        } catch (UserNotFound e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;


    }

    @PutMapping("/updateuser/{id}")
    public UserDetails updateUser(@PathVariable("id") int userId, @RequestBody UserDetails userDetails) {

        return userService.updateUser(userId, userDetails);
    }

    @GetMapping("/getalluser")
    public List<UserDetails> getallUserDetails() {

        return userService.getAllUser();
    }


}
