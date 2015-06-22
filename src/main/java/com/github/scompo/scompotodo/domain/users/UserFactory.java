package com.github.scompo.scompotodo.domain.users;

public class UserFactory {

	public static User create(String username, String email) {

		User res = new User();

		res.setUsername(username);
		res.setEmail(email);

		return res;
	}
}
