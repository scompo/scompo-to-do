package com.github.scompo.scompotodo.service.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloBusinessService implements HelloService {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloBusinessService.class);

	@Override
	public String sayHello() {

		logger.debug("called sayHello");

		return HELLO_STRING;
	}

}
