package com.greatlearning.EmployeeManagementREST;

import com.greatlearning.EmployeeManagementREST.entites.Roles;
import com.greatlearning.EmployeeManagementREST.entites.User;
import com.greatlearning.EmployeeManagementREST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeManagementRestApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserId(1);
		user.setUserName("admin1");
		user.setUserPassword(new BCryptPasswordEncoder().encode("123"));
		List<Roles> roles = new ArrayList<>();
		roles.add(new Roles(1,"ADMIN"));
		user.setRolesList(roles);
		userRepository.save(user);
	}
}
