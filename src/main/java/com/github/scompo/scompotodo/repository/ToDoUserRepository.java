package com.github.scompo.scompotodo.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.scompotodo.domain.ToDoUser;

public interface ToDoUserRepository extends GraphRepository<ToDoUser>{

	ToDoUser findByLogin(String login);
}
