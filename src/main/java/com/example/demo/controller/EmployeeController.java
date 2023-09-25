package com.example.demo.controller;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    @Qualifier("impl1")
    private EmployeeService employeeService;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserPrincipal principal){
        if(principal!=null){
            return "ID: "+principal.getAuthorities()+principal.getUsername();
        }return "oops";
    }

    @GetMapping("/get")
    public List<EmployeeEntity> getEmployee(){
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
