package com.github.scompo.scompotodo.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.scompo.scompotodo.domain.User;

public interface ToDoUserRepository extends GraphRepository<User>{

	User findByLogin(String login);
}
