package com.github.scompo.scompotodo.domain.todoitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemDao extends CrudRepository<ToDoItem, Long> {

	Page<ToDoItem> findByTableId(Long tableId, Pageable pageable);
}
