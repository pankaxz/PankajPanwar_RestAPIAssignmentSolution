package com.greatlearning.EmployeeManagementREST.repository;

import com.greatlearning.EmployeeManagementREST.entites.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    public Roles findRoleByRoleName(String roleName);
}
