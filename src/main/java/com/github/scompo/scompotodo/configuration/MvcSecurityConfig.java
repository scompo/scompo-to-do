package com.github.scompo.scompotodo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.github.scompo.scompotodo.services.ToDoUserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ToDoUserDetailsService toDoUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/v1/**", "/init", "/register", "/js/**")
				.permitAll().anyRequest().authenticated().and().formLogin()
				.defaultSuccessUrl("/home", true).loginPage("/login")
				.permitAll().and().logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.userDetailsService(toDoUserDetailsService);
	}
}
