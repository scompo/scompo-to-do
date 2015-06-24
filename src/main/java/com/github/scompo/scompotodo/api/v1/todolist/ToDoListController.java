package com.github.scompo.scompotodo.api.v1.todolist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.scompo.scompotodo.api.v1.V1ApiEndpoints;
import com.github.scompo.scompotodo.domain.todoitem.ToDoItem;
import com.github.scompo.scompotodo.domain.todolist.ToDoList;
import com.github.scompo.scompotodo.service.todoitem.ToDoItemService;
import com.github.scompo.scompotodo.service.todolist.ToDoListService;

@RestController
@RequestMapping(value = V1ApiEndpoints.ToDoListEndpoints.TODO)
public class ToDoListController {

	private static final Logger logger = LoggerFactory
			.getLogger(ToDoListController.class);

	@Autowired
	private ToDoListService toDoListService;
	
	@Autowired
	private ToDoItemService toDoItemService;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Page<ToDoList> getPaged(@PathVariable String username,
			Pageable pageable) {

		logger.info("called getPaged={}, username={}", pageable, username);

		return toDoListService.getPagedForUsername(pageable, username);
	}

	@RequestMapping(value = "/{username}/{id}", method = RequestMethod.GET)
	public Page<ToDoItem> getPagedItems(@PathVariable String username,
			@PathVariable Long id, Pageable pageable) {

		logger.info(
				"called getPagedItems with pageable={}, id={}, username={},",
				pageable, id, username);

		return toDoItemService.getPagedForUsername(pageable, username, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ToDoList save(@RequestBody ToDoList toDoList) {

		logger.info("called toDoList={}", toDoList);

		return toDoListService.create(toDoList);
	}
}
