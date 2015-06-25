package com.github.scompo.scompotodo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.github.scompo.scompotodo.domain.ToDoUser;

public interface ToDoUserDetailsService extends UserDetailsService {

	ToDoUser getUserFromSession();

	void init();

	ToDoUser save(ToDoUser userSaved1);
}
