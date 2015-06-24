package com.github.scompo.scompotodo.domain.todolist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToDoListDao extends PagingAndSortingRepository<ToDoList, Long> {

	Page<ToDoList> findByCreator(String creator, Pageable pageable);
}
