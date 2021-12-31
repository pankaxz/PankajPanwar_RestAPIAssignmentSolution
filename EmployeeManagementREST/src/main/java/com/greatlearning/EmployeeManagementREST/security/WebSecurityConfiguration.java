package com.greatlearning.EmployeeManagementREST.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import com.greatlearning.EmployeeManagementREST.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    protected void configure(HttpSecurity https) throws Exception{
        https.authorizeRequests()
                .antMatchers(
                        "/",
                        "/login",
                        "/employee",
                        "/employee/list_employee",
                        "/employee/{empID}",
                        "/employee/search",
                        "/employee/update_employee/{empID}",
                        "/delete_employee/{empID}").hasAnyAuthority("USER", "ADMIN")

                .antMatchers("/user/**","/employee/add_employee/","/h2-console/**").hasAuthority("ADMIN")

                .antMatchers("/user/add_user",
                        "/employee/add_employee/",
                        "/employee/update_employee/{empID}",
                        "/delete_employee/{empID}").hasAuthority("ADMIN")

                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/login").successForwardUrl("/employee").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and().cors().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
    }
}
