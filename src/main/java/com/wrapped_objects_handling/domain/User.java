package com.wrapped_objects_handling.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  UUID id;
  String username;
  String password;
  Date dateCreated;

}
