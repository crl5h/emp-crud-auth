package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeImpl implements EmployeeService{
    private final EmployeeRepository empRepo;

    public List<EmployeeEntity> getAll(){
        return empRepo.findAll();
    }

    public EmployeeEntity getById(int id){
        return empRepo.findById(id).get();
    }

    public void addEmployee(EmployeeEntity employee){
        empRepo.save(employee);
    }

    public void updateEmployee(int employeeId, EmployeeEntity UpdatedEmployee) {
        EmployeeEntity currEmp = empRepo.findById(employeeId).get();
        currEmp.setName(UpdatedEmployee.getName());
        currEmp.setSalary(UpdatedEmployee.getSalary());
        empRepo.save(currEmp);
    }

    public void deleteEmployee(int id){
        empRepo.deleteById(id);
    }

}
