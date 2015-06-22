package com.github.scompo.scompotodo.test.constants;

import com.github.scompo.scompotodo.domain.users.User;

public abstract class UsersTestConstants {

	public enum UsersForTestType {

		USER_OK_1
	}

	public static final String USERNAME_1 = "username1";

	public static final String EMAIL_1 = "test1@test.com";
	
	public static final String EMAIL_2 = "test2@test.com";

	public static User createUser(UsersForTestType type) {

		User res = new User();

		switch (type) {

		case USER_OK_1:

			res.setUsername(USERNAME_1);
			res.setEmail(EMAIL_1);
			break;

		default:
			break;
		}

		return res;
	}

}
