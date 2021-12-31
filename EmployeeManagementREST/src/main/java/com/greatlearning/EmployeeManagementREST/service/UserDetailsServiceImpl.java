package com.greatlearning.EmployeeManagementREST.service;
import com.greatlearning.EmployeeManagementREST.entites.User;
import com.greatlearning.EmployeeManagementREST.repository.UserRepository;
import com.greatlearning.EmployeeManagementREST.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.getByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("Username not valid!");
        return new MyUserDetails(user);
    }
}
