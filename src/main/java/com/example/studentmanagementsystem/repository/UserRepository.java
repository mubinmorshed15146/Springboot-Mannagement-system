package com.example.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.studentmanagementsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 public User findByEmail(String email);
}
