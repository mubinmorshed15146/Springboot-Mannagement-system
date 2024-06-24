package com.example.studentmanagementsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.studentmanagementsystem.entity.User;
import com.example.studentmanagementsystem.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

  public User save(UserRegistrationDto registrationDto);
}
