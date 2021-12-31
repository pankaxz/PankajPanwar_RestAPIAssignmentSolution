package com.greatlearning.EmployeeManagementREST.service;

import com.greatlearning.EmployeeManagementREST.entites.Employee;
import com.greatlearning.EmployeeManagementREST.repository.EmployeeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    @Override
    public List<Employee> findALlEmployee() {
        return employeeServiceRepository.findAll();
    }

    @Override
    public void addEmployee(Employee newEmployee) {
        employeeServiceRepository.save(newEmployee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeServiceRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(int id, Employee newEmployee) {
        Employee employee;
        if(id != 0) {
            employee = findEmployeeById(id);
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
        }else {
            employee = new Employee(newEmployee.getFirstName(),
                                    newEmployee.getLastName(),
                                    newEmployee.getEmail());
        }
        employeeServiceRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeServiceRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchByFirstName(String pattern) {
        return employeeServiceRepository.findByFirstNameContainsAllIgnoreCase(pattern);
    }

    @Override
    public List<Employee> sortByFirstName(String order) {
        List<Employee> sortedList = employeeServiceRepository.findAll();

        if(order.equals("\"asc\"") || order.equals(("asc")))
            sortedList = employeeServiceRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        else if(order.equals("\"desc\"") || order.equals("desc"))
            sortedList = employeeServiceRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));

        return sortedList;
    }
}
