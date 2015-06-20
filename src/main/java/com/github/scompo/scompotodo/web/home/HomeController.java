package com.github.scompo.scompotodo.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {

		return "/pages/main/index";
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {

		return "/pages/hello/index";
	}
}
