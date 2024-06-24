package com.example.studentmanagementsystem.web;

import com.example.studentmanagementsystem.service.UserService;
import com.example.studentmanagementsystem.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is a controller class to connect the project to redirect in the view. 
 *
 * @author mubin
 *
 */
@Controller
@RequestMapping("/registration")
public class UserController {
  private UserService service;

  public UserController(UserService service) {
    super();
    this.service = service;
  }

  @GetMapping
  public String showRegistration(Model model) {
    model.addAttribute("user", new UserRegistrationDto());
    return "registration";
  }

  // in @ModelAttributte "user" object will be used in the UI or front end layer
  @PostMapping
  public String registerAccount(@ModelAttribute("user") UserRegistrationDto dto) {
    service.save(dto);
    return "redirect:/registration?success";
  }
}
