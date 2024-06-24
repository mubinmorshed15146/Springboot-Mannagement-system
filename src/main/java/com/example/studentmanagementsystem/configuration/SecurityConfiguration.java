package com.example.studentmanagementsystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.example.studentmanagementsystem.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Autowired
  private UserService userService;


  // passing the authentication provider to configure
  @Autowired
  public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(encoder());

  }

  // creating a password encoder bean so that it can be used to encode the password for further
  // security
  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  // Because we are using spring data jpa and hibernate we have to use a bean that will be called
  // DAO authentication Provider
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userService);
    authenticationProvider.setPasswordEncoder(encoder());
    return authenticationProvider;

  }

  // Creating this bean to enable configure base springboot security filter chain
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // creating spring configure so that we can build our own configure
    http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
        authorized -> authorized.requestMatchers("/students", "/students/new", "/students/edit")
            .authenticated().anyRequest().permitAll());
    // .httpBasic(Customizer.withDefaults())
    http.formLogin(login -> login.permitAll().loginPage("/login"))
        .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
            .logoutSuccessUrl("/login?logout").logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .permitAll());


    return http.build();
  }

}
