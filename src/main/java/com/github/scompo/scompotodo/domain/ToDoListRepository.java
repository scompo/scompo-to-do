package com.github.scompo.scompotodo.domain;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface ToDoListRepository extends GraphRepository<ToDoList> {

}
