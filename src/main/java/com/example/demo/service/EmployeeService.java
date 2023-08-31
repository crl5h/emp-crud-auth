package com.example.demo.service;
import com.example.demo.entity.EmployeeEntity;

import java.util.List;


public interface EmployeeService {
    //2. Get Employee By Id (GET)
    //3. Add Employee (POST)
    //4. Update Employee (PUT)
    //5. Delete Employee (DELETE)

    //1. Get All Employees (GET)
    List <EmployeeEntity> getAll();
    EmployeeEntity getById(int id);
    void updateEmployee(int employeeId, EmployeeEntity employee);
    void addEmployee(EmployeeEntity employee);
    void deleteEmployee(int id);

}