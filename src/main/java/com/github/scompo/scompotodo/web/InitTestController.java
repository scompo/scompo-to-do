package com.github.scompo.scompotodo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.scompo.scompotodo.domain.ToDoUserDetailsService;

@RestController
public class InitTestController {
	
	@Autowired
	private ToDoUserDetailsService toDoUserDetailsService;

	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String init() {

		toDoUserDetailsService.init();
		return "init";
	}
}
