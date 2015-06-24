package com.github.scompo.scompotodo.service.todoitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.scompo.commons.CrudService;
import com.github.scompo.scompotodo.domain.todoitem.ToDoItem;

public interface ToDoItemService extends CrudService<ToDoItem, Long> {

	Page<ToDoItem> getPagedForUsername(Pageable pageable, String username,
			Long id);

}
