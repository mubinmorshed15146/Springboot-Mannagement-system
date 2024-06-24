package com.example.studentmanagementsystem.entity;

public enum Responsibility {
  USER("user"),ADMIN("admin");
  
  private String string;

  Responsibility(String string) {
    this.string = string;
  }
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return string;
  }

}
