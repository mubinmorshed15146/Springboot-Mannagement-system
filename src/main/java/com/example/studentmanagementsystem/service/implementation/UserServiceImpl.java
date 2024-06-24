package com.example.studentmanagementsystem.service.implementation;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.studentmanagementsystem.entity.Role;
import com.example.studentmanagementsystem.entity.User;
import com.example.studentmanagementsystem.repository.UserRepository;
import com.example.studentmanagementsystem.service.UserService;
import com.example.studentmanagementsystem.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {


  private UserRepository repository;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;


  public UserServiceImpl(UserRepository repository) {
    super();
    this.repository = repository;
  }


  @Override
  public User save(UserRegistrationDto registrationDto) {
    User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
        registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
        Arrays.asList(new Role("ROLE_USER")));
    return repository.save(user);
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //retrieved users's email or user name
    User user = repository.findByEmail(username);
    //checking is it null or not
    if (user == null) {
      throw new UsernameNotFoundException("Invalid User Name or Password");
    }
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), mapRolesToAuthorities(user.getRole()));
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> role) {
    return role.stream().map(roles -> new SimpleGrantedAuthority(roles.getName()))
        .collect(Collectors.toList());

  }

}
