package com.example.demo.controller;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//jpa repo(db)

@RestController
public class EmployeeController {

    @Autowired
    @Qualifier("impl1")
    private EmployeeService employeeService;

    @GetMapping("/")
    public String func(){
//        System.out.println("works");
        return "works";
    }

    @GetMapping("/pvt")
    public String test(){
        return "Private page";
    }

    @ResponseBody
    @GetMapping("/get")
    public List<EmployeeEntity> getEmployee(){
        // System.out.println(employeeService.getAll());
        return employeeService.getAll();
    }

    @PostMapping("/post")
    public void addEmployee(@RequestBody EmployeeEntity employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public EmployeeEntity getEmpById(@PathVariable("id") int id){
        return employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public void getEmployeeService(@PathVariable(value = "id") int employeeId,
                                   @RequestBody EmployeeEntity employeeDetails) {
        employeeService.updateEmployee(employeeId,employeeDetails);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }
}
