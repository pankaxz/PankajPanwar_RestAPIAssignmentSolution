package com.greatlearning.EmployeeManagementREST.service;

import com.greatlearning.EmployeeManagementREST.entites.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    List<Employee> findALlEmployee();
    void addEmployee(Employee newEmployee);
    Employee findEmployeeById(int id);
    void updateEmployee(int id, Employee newEmployee);
    void deleteEmployee(int id);
    List<Employee> searchByFirstName(String pattern);
    List<Employee> sortByFirstName(String order);
}
