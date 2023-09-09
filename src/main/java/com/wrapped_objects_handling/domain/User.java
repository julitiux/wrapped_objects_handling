package com.wrapped_objects_handling.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  UUID id;
  String username;
  String password;
  @CreationTimestamp
  Date dateCreated;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
