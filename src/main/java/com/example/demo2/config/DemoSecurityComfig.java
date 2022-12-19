package com.example.demo2.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityComfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource securityDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 auth.jdbcAuthentication().dataSource(securityDataSource).usersByUsernameQuery("select username, password, active from user where username=?").authoritiesByUsernameQuery("select username, role from user where username=?");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/register**").permitAll()
		.antMatchers("/processregistration").permitAll()
		.antMatchers("/add**").hasRole("ADMIN")
		.antMatchers("/manage**").hasRole("ADMIN")
		.antMatchers("/delet**").hasRole("ADMIN")
		.anyRequest().authenticated().and().formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied");
	}
	
}
