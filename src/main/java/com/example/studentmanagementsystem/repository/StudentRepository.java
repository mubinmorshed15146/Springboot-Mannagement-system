package com.example.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentmanagementsystem.entity.Students;

/*
 * JpaRepository will take 2 parameter first one will be the class name and the second one will be
 * the type of the id.
 * We don't have to add @Repository annotation because the JpaRepository class
 * has it's own annotation that will reduce the need of the annotation
 */
public interface StudentRepository extends JpaRepository<Students, Long> {

}
