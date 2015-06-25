package com.github.scompo.scompotodo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.github.scompo.scompotodo.domain.User;

public interface ToDoUserDetailsService extends UserDetailsService {

	User getUserFromSession();

	void init();

	User save(User userSaved1);
}
