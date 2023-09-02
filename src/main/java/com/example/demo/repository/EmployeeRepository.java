package com.example.demo.repository;

import com.example.demo.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}


//1. Get All Employees (GET)
//2. Get Employee By Id (GET)

//3. Add Employee (POST)
//4. Update Employee (PUT)
//5. Delete Employee (DELETE)
