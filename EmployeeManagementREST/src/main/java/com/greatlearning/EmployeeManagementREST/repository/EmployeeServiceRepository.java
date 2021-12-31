package com.greatlearning.EmployeeManagementREST.repository;

import com.greatlearning.EmployeeManagementREST.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeServiceRepository extends JpaRepository<Employee, Integer> {
    public List<Employee>findByFirstNameContainsAllIgnoreCase(String pattern);
}
