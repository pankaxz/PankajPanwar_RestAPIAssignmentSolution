package com.greatlearning.EmployeeManagementREST.controller;

import com.greatlearning.EmployeeManagementREST.entites.Roles;
import com.greatlearning.EmployeeManagementREST.entites.User;
import com.greatlearning.EmployeeManagementREST.repository.RoleRepository;
import com.greatlearning.EmployeeManagementREST.service.UserService;
import com.greatlearning.EmployeeManagementREST.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list_users")
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @PostMapping("/add_user")
    public User AddNewUser(@RequestBody User newUser, String role_name){
       return userService.addNewUser(newUser, role_name);
    }

    @PostMapping("/add_role")
    public Roles AddNewRole(@RequestBody Roles newRole){
        return userService.addNewRole(newRole);
    }

    @GetMapping("/list_roles")
    public List<Roles> FindALlRoles(){return userService.findAllRoles();}
}
