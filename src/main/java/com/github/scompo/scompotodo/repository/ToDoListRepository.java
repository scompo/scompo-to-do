package com.github.scompo.scompotodo.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.scompotodo.domain.ToDoList;

public interface ToDoListRepository extends GraphRepository<ToDoList> {

}
