package com.greatlearning.EmployeeManagementREST.service;

import com.greatlearning.EmployeeManagementREST.entites.Roles;
import com.greatlearning.EmployeeManagementREST.entites.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    List<Roles> findAllRoles();
    User addNewUser(User newUser, String roleName);
    Roles addNewRole(Roles newRole);
    Roles addNewRole(String roleName);
}
