package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "salary")
    private int salary;
    @Column(name = "name")
    private String name;
    @Column(name = "mobile")
    private String mobileNumber;
    @Column(name = "department")
    private String departmentName;
    @Column(name = "dob")
    private Date dob;
}
