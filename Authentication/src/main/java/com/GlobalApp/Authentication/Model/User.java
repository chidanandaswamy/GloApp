package com.GlobalApp.Authentication.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  private String email;
  private String password;
  private ERole role;

  public User() {
  }

  public User(String email, String password, ERole role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ERole getRole() {
    return role;
  }

  public void setRole(ERole role) {
    this.role = role;
  }
}