package com.greatlearning.EmployeeManagementREST.controller;

import com.greatlearning.EmployeeManagementREST.entites.Employee;
import com.greatlearning.EmployeeManagementREST.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public String home() {
        return "Welcome to Employee Management Portal";
    }

    @GetMapping("/list_employee")
    private List<Employee> findAllEmployee(){
        return employeeService.findALlEmployee();
    }

    @PostMapping("/add_employee")
    private void AddNewEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping("/{empID}")
    private Employee FindEmployeeById(@PathVariable int empID){
        return employeeService.findEmployeeById(empID);
    }

    @PostMapping("/update_employee/{empID}")
    private void UpdateEmployeeById(@PathVariable int empID, @RequestBody Employee employee) {
        if (empID != 0) {employeeService.updateEmployee(empID, employee);}
    }

    @DeleteMapping("/delete_employee/{empID}")
    private String DeleteEmployeeById(@PathVariable int empID){
        if (empID != 0) {
            if (employeeService.findEmployeeById(empID) != null){
                employeeService.deleteEmployee(empID);
            }
        }
        return String.format("Deleted employee with id: %d", empID);
    }

    @GetMapping("/sort")
    private List<Employee> SortByFirstName(@RequestParam String order){
        return employeeService.sortByFirstName(order);
    }

    @GetMapping("/search")
    private List<Employee> SearchByFirstName(@RequestParam String pattern){
        return employeeService.searchByFirstName(pattern);
    }
}
