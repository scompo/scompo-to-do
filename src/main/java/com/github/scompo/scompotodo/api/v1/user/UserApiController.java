package com.github.scompo.scompotodo.api.v1.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.scompo.scompotodo.domain.User;
import com.github.scompo.scompotodo.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserApiController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserApiController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public User save(@RequestBody User user) {

		logger.info("Called save with user={}", user);

		return userRepository.save(user);
	}

}
