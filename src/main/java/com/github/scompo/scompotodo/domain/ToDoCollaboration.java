package com.github.scompo.scompotodo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "COLLABORATOR_ON")
public class ToDoCollaboration extends AbstractEntity{

	@StartNode
	private ToDoUser user;

	@EndNode
	private ToDoList list;

	private CollaborationRole role;

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

	@Override
	public String toString() {
		return "ToDoCollaboration [id=" + getId() + ", user=" + user + ", list="
				+ list + ", role=" + role + "]";
	}
}
