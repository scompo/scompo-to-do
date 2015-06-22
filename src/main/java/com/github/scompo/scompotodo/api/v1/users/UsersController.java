package com.github.scompo.scompotodo.api.v1.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.scompo.scompotodo.api.v1.V1ApiEndpoints;
import com.github.scompo.scompotodo.domain.users.User;
import com.github.scompo.scompotodo.service.users.UsersService;

@RestController
@RequestMapping(value = V1ApiEndpoints.UsersEndpoints.USER)
public class UsersController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsersController.class);

	@Autowired
	private UsersService usersService;

	@RequestMapping(method = RequestMethod.POST)
	public User save(@RequestBody User user) {

		logger.info("called save with user={}", user);

		return usersService.create(user);
	}

}
