package com.github.scompo.scompotodo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "COLLABORATOR_ON")
public class Collaboration extends AbstractEntity{

	@StartNode
	private User user;

	@EndNode
	private List list;

	private CollaborationRole role;

	public Collaboration() {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
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
