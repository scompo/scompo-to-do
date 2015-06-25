package com.github.scompo.scompotodo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.scompotodo.domain.AuthorizationRole;
import com.github.scompo.scompotodo.domain.User;
import com.github.scompo.scompotodo.domain.ToDoUserDetails;
import com.github.scompo.scompotodo.repository.UserRepository;

@Service
@Transactional
public class ToDoUserDetailsServiceImpl implements ToDoUserDetailsService {

	@Autowired
	private UserRepository toDoUserRepository;

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		User user = findByLogin(login);

		if (user == null) {

			throw new UsernameNotFoundException("username not found: " + login);
		}

		return new ToDoUserDetails(user);
	}

	private User findByLogin(String login) {

		return toDoUserRepository.findByLogin(login);
	}

	@Override
	public User getUserFromSession() {

		SecurityContext securityContext = SecurityContextHolder.getContext();

		Authentication authentication = securityContext.getAuthentication();

		Object principal = authentication.getPrincipal();

		if (principal instanceof ToDoUserDetails) {

			ToDoUserDetails toDoUserDetails = (ToDoUserDetails) principal;

			return toDoUserDetails.getUser();
		}

		return null;
	}

	@Override
	public void init() {

		User testUser = new User();

		testUser.setLogin("test");
		testUser.setPassword("test");
		testUser.setName("test");
		Set<AuthorizationRole> roles = new HashSet<AuthorizationRole>();

		roles.add(AuthorizationRole.ROLE_ADMIN);
		testUser.setAuthorizationRoles(roles);

		toDoUserRepository.save(testUser);
	}

	@Override
	public User save(User userSaved) {
		
		return toDoUserRepository.save(userSaved);
	}

}
