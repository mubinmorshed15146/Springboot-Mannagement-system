package com.example.studentmanagementsystem.service;

import java.util.List;
import com.example.studentmanagementsystem.entity.Students;

public interface StdService {

  List<Students> getAllStudents();
  public Students saveStudent(Students std);
  public Students getStudentById(Long id);
  public Students updateStudent(Students student);
  public void delete(Long id);
}
