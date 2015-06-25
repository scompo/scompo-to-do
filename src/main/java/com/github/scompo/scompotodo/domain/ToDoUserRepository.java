package com.github.scompo.scompotodo.domain;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface ToDoUserRepository extends GraphRepository<ToDoUser>{

	ToDoUser findByLogin(String login);
}
