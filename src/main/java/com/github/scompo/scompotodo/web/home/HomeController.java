package com.github.scompo.scompotodo.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {

		return "main";
	}

	@RequestMapping(value = "hello")
	public String hello() {

		return "hello";
	}
}
