package com.example.project;

import com.example.project.model.Employee;
import com.example.project.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private  EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") Long id){
        Employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newemployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newemployee, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee){
        Employee updateemployee=employeeService.UpdateEmployee(employee);
        return new ResponseEntity<>(updateemployee, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
       employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
