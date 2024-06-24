package com.example.studentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication  {

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementSystemApplication.class, args);
  }

//  @Autowired
//  private StdService service;
//  @Override
//  public void run(String... args) throws Exception {
//   Students std1 = new Students("Mubin","Morshed","maher26bd@gmail.com",15146);
//   service.saveStudent(std1);
//   
//
//  }

}
