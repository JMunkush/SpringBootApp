package com.munkush.MySpringBootApp.controller.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 2,max = 128,message = "Name should be between 2-128 characters")
    @NotEmpty(message = "Name shouldnt be empty")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email shouldnt be emty")
    @Column(name = "email")
    private String email;


}
