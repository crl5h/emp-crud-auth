package com.example.demo.controller;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/test")
    public String testCheck(){
        return "Works for all users.";
    }

    @GetMapping("/profile")
    // can be accessed by users with BOTH create and view permissions
    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER') or hasPermission('','EMPLOYEE','VIEW@USER') ")
    public String profile(@AuthenticationPrincipal UserPrincipal principal){
        if(principal!=null){
            return "ID: "+principal.getAuthorities()+principal.getUsername();
        }return "oops";
    }

    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER') or hasPermission('','EMPLOYEE','VIEW@USER')")
    @GetMapping("/get")
    public List<EmployeeEntity> getEmployee(){
        return employeeService.getAll();
    }

    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER')")
    @PostMapping("/post")
    public void addEmployee(@RequestBody EmployeeEntity employee){
        employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER') or hasPermission('','EMPLOYEE','VIEW@USER')")
    @GetMapping("/get/{id}")
    public EmployeeEntity getEmpById(@PathVariable("id") int id){
        return employeeService.getById(id);
    }

    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER')")
    @PutMapping("/update/{id}")
    public void getEmployeeService(@PathVariable(value = "id") int employeeId,
                                   @RequestBody EmployeeEntity employeeDetails) {
        employeeService.updateEmployee(employeeId,employeeDetails);
    }

    @PreAuthorize("hasPermission('','EMPLOYEE','DELETE@USER')")
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }
}
