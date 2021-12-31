package com.greatlearning.EmployeeManagementREST.repository;

import com.greatlearning.EmployeeManagementREST.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserName(String username);
}
