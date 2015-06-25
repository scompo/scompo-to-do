package com.github.scompo.scompotodo.domain;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ToDoUserDetails implements UserDetails {

	private static final long serialVersionUID = 8918008519655106183L;

	private static final boolean DEFAULT_VALUE = true;

	private User user;

	public ToDoUserDetails(User user) {

		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<AuthorizationRole> roles = user.getAuthorizationRoles();

		if (roles == null || roles.isEmpty()) {

			roles = Collections.emptyList();
		}

		return roles;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {

		return DEFAULT_VALUE;
	}

	@Override
	public boolean isAccountNonLocked() {

		return DEFAULT_VALUE;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return DEFAULT_VALUE;
	}

	@Override
	public boolean isEnabled() {

		return DEFAULT_VALUE;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
