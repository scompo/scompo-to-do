package com.github.scompo.scompotodo.domain.users;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -9106224958247355898L;

	private Collection<GrantedAuthority> authorities;

	private String username;

	private String password;

	public UserDetailsImpl(String username, String password) {

		authorities = new ArrayList<GrantedAuthority>();

		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(
				"ROLE_USER");

		authorities.add(simpleGrantedAuthority);

		this.username = username;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
