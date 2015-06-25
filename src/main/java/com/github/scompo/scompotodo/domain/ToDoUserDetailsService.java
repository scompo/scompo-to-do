package com.github.scompo.scompotodo.domain;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface ToDoUserDetailsService extends UserDetailsService {

	ToDoUser getUserFromSession();

	void init();

	ToDoUser save(ToDoUser userSaved1);
}
