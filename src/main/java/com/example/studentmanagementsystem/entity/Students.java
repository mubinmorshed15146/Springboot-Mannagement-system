package com.example.studentmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Students {

  public Students(String fName, String lName, String email, long id) {
    super();
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.id = id;
  }

  public Students() {
    super();
  }

  @Id
  private long id;
  @Column(name = "first_name", nullable = false)
  private String fName;
  @Column(name = "last_name", nullable = false)
  private String lName;
  @Column(name = "email")
  private String email;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getfName() {
    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
