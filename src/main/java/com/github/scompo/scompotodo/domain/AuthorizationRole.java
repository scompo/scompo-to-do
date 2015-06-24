package com.github.scompo.scompotodo.domain;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorizationRole implements GrantedAuthority {

	ROLE_USER,

	ROLE_ADMIN;

	@Override
	public String toString() {

		return name();
	}

	@Override
	public String getAuthority() {

		return toString();
	}
}