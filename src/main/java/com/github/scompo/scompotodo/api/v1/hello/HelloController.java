package com.github.scompo.scompotodo.api.v1.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.scompo.scompotodo.api.v1.V1ApiEndpoints;
import com.github.scompo.scompotodo.service.hello.HelloService;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);

	@Autowired
	private HelloService helloService;

	@ResponseBody
	@RequestMapping(value = V1ApiEndpoints.HelloEndpoints.HELLO, method = RequestMethod.GET)
	public String sayHello() {

		logger.info("called sayHello");

		return helloService.sayHello();
	}
}
