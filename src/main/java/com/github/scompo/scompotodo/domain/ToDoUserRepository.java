package com.github.scompo.scompotodo.domain;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

public interface ToDoUserRepository extends GraphRepository<ToDoUser>,
		RelationshipOperationsRepository<ToDoUser> {

	ToDoUser findByLogin(String login);
}
