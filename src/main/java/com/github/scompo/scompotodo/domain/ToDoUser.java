package com.github.scompo.scompotodo.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class ToDoUser {
	
	@GraphId
	private Long id;

	@Indexed(unique = true, failOnDuplicate = true)
	private String login;

	private String name;

	private String password;

	private Set<AuthorizationRole> authorizationRoles;
	
	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.OUTGOING)
	private Collection<ToDoCollaboration> collaborations;

	@RelatedTo(type = "COLLABORATOR_ON", direction = Direction.OUTGOING)
	private Set<ToDoList> lists;

	public ToDoUser() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<AuthorizationRole> getAuthorizationRoles() {
		return authorizationRoles;
	}

	public void setAuthorizationRoles(Set<AuthorizationRole> authorizationRoles) {
		this.authorizationRoles = authorizationRoles;
	}

	public Set<ToDoList> getLists() {
		return lists;
	}

	public void setLists(Set<ToDoList> lists) {
		this.lists = lists;
	}

	public ToDoCollaboration partOf(ToDoList list, CollaborationRole role) {

		return partOf(list, role, LocalDate.now());
	}

	public ToDoCollaboration partOf(ToDoList list, CollaborationRole role, LocalDate date) {

		ToDoCollaboration res = new ToDoCollaboration();

		res.setUser(this);
		res.setList(list);
		res.setRole(role);
		res.setDate(date);

		return res;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
