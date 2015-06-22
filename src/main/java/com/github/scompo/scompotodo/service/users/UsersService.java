package com.github.scompo.scompotodo.service.users;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.github.scompo.commons.CrudService;
import com.github.scompo.scompotodo.domain.users.User;

public interface UsersService extends CrudService<User, String>, UserDetailsService{

}
