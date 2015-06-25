package com.github.scompo.scompotodo.test.domain;

import java.util.HashSet;
import java.util.Set;

import com.github.scompo.scompotodo.domain.AuthorizationRole;
import com.github.scompo.scompotodo.domain.ToDoList;
import com.github.scompo.scompotodo.domain.ToDoUser;

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

	public static ToDoUser createUser(String login, String password, String name) {

		ToDoUser userToCreate = new ToDoUser();

		Set<AuthorizationRole> authorizationRoles = new HashSet<>();

		authorizationRoles.add(AuthorizationRole.ROLE_ADMIN);
		authorizationRoles.add(AuthorizationRole.ROLE_USER);

		userToCreate.setAuthorizationRoles(authorizationRoles);
		userToCreate.setLogin(login);
		userToCreate.setPassword(password);
		userToCreate.setName(name);

		return userToCreate;
	}

	public static ToDoList createList(String name) {

		ToDoList res = new ToDoList();

		res.setName(name);

		return res;
	}
}
