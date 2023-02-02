package com.GloQoura.userdetails.repo;

import com.GloQoura.userdetails.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    UserDetails findByUserName(String name);

}
