package com.greatlearning.EmployeeManagementREST.service;

import com.greatlearning.EmployeeManagementREST.entites.Roles;
import com.greatlearning.EmployeeManagementREST.entites.User;
import com.greatlearning.EmployeeManagementREST.repository.RoleRepository;
import com.greatlearning.EmployeeManagementREST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(User newUser, String role_name) {
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setUserPassword(new BCryptPasswordEncoder().encode(newUser.getUserPassword()));
        System.out.println("user_role : at 31"+ role_name);

        List<Roles> roles = new ArrayList<>();
        Roles role = roleRepository.findRoleByRoleName(role_name);
        if (role == null)
            role = addNewRole(role_name);
        roles.add(role);
        user.setRolesList(roles);

        user.setRolesList(roles);
        newUser.setRolesList(roles);

        return userRepository.save(user);
    }

    @Override
    public List<Roles> findAllRoles() { return roleRepository.findAll(); }

    @Override
    public Roles addNewRole(Roles newRole) {
        System.out.println("Adding new role : " + newRole);
            return roleRepository.save(newRole);
    }

    @Override
    public Roles addNewRole(String roleName) {
        Roles role = roleRepository.findRoleByRoleName(roleName);
        if (role != null)
            return role;
        role = new Roles();
        role.setRoleName(roleName);
        return roleRepository.save(role);
    }
}
