package com.example.studentmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * This is a class to make the table into the database and store the data. The annotation @Entity
 * will be used to make the springboot component to recognize this as a entity table.
 *
 * @author mubin
 *
 */
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
public class Role {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;

  public Role(String name) {
    super();
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
