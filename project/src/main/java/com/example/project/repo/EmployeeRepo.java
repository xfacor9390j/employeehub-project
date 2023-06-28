package com.example.project.repo;

import com.example.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(long id);

    Optional<Employee> findEmployeeById(long id);
}
