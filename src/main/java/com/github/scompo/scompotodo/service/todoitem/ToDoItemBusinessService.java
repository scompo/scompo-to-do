package com.github.scompo.scompotodo.service.todoitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.scompo.commons.AbstractCrudService;
import com.github.scompo.scompotodo.domain.todoitem.ToDoItem;
import com.github.scompo.scompotodo.domain.todoitem.ToDoItemDao;

@Service
public class ToDoItemBusinessService extends
		AbstractCrudService<ToDoItem, Long> implements ToDoItemService {

	@Override
	public Page<ToDoItem> getPagedForUsername(Pageable pageable,
			String username, Long id) {

		return ((ToDoItemDao) getRepository()).findByTableId(id, pageable);
	}

	@Override
	public ToDoItem doUpdate(ToDoItem fromDb, ToDoItem dto) {

		return fromDb;
	}

}
