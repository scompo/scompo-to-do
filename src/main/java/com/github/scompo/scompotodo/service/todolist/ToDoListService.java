package com.github.scompo.scompotodo.service.todolist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.scompo.commons.CrudService;
import com.github.scompo.scompotodo.domain.todolist.ToDoList;

public interface ToDoListService extends CrudService<ToDoList, Long>{

	Page<ToDoList> getPagedForUsername(Pageable pageable, String username);

}
