package com.GlobalApp.Authentication.repo;

import com.GlobalApp.Authentication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<User, String>{

}
