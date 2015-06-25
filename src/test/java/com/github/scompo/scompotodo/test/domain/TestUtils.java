package com.github.scompo.scompotodo.test.domain;

import java.util.HashSet;
import java.util.Set;

import com.github.scompo.scompotodo.domain.AuthorizationRole;
import com.github.scompo.scompotodo.domain.List;
import com.github.scompo.scompotodo.domain.User;

public abstract class TestUtils {

	private TestUtils() {

	}

	public static final String USER_NAME_1 = "User Name 1";

	public static final String USER_PASSWORD_1 = "userPassword1";

	public static final String USER_LOGIN_1 = "userLogin1";

	public static final String USER_NAME_2 = "User Name 2";

	public static final String USER_PASSWORD_2 = "userPassword2";

	public static final String USER_LOGIN_2 = "userLogin2";
	
	public static final String LIST_NAME = "listName";

	public static User createUser(String login, String password, String name) {

		User userToCreate = new User();

		Set<AuthorizationRole> authorizationRoles = new HashSet<>();

		authorizationRoles.add(AuthorizationRole.ROLE_ADMIN);
		authorizationRoles.add(AuthorizationRole.ROLE_USER);

		userToCreate.setAuthorizationRoles(authorizationRoles);
		userToCreate.setLogin(login);
		userToCreate.setPassword(password);
		userToCreate.setName(name);

		return userToCreate;
	}

	public static List createList(String name) {

		List res = new List();

		res.setName(name);

		return res;
	}
}
