package com.example.studentmanagementsystem.configuration;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.studentmanagementsystem.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private JwtService service;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    final String authenticationHeader = request.getHeader("Authorization");
    String jwtToken;
    if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;

    }
    jwtToken = authenticationHeader.substring(7);
    final String userName = service.extractUserName(jwtToken);

  }

}
