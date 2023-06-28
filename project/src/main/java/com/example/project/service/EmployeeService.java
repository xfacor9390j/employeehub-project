package com.example.project.service;

import com.example.project.exception.UserNotFoundException;
import com.example.project.model.Employee;
import com.example.project.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
   @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
       employee.setEmployeeCode(UUID.randomUUID().toString());
       return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
       return employeeRepo.findAll();
    }
    public Employee UpdateEmployee(Employee employee){
       return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(long id){
       return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("user by id"+id+"was not found"));
    }
    public void deleteEmployee(long id){
       employeeRepo.deleteEmployeeById(id);

    }

}
