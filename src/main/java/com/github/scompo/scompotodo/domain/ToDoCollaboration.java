package com.github.scompo.scompotodo.domain;

import java.time.LocalDate;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "COLLABORATOR_ON")
public class ToDoCollaboration {

	@GraphId
	private Long id;

	@StartNode
	private ToDoUser user;

	@EndNode
	private ToDoList list;

	private CollaborationRole role;

	private LocalDate date;

	public ToDoCollaboration() {

	}

	public ToDoUser getUser() {
		return user;
	}

	public void setUser(ToDoUser user) {
		this.user = user;
	}

	public ToDoList getList() {
		return list;
	}

	public void setList(ToDoList list) {
		this.list = list;
	}

	public CollaborationRole getRole() {
		return role;
	}

	public void setRole(CollaborationRole role) {
		this.role = role;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
