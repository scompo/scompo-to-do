package com.github.scompo.scompotodo.domain;

import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class ToDoUser extends AbstractEntity{

	@Indexed(unique = true, failOnDuplicate = true)
	private String login;

	private String name;

	private String password;

	private Set<AuthorizationRole> authorizationRoles;
	
	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.OUTGOING)
	private Collection<ToDoCollaboration> collaborations;

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
	
	public ToDoCollaboration userOf(ToDoList list, CollaborationRole role){
		
		ToDoCollaboration toDoCollaboration = new ToDoCollaboration();
		toDoCollaboration.setUser(this);
		toDoCollaboration.setList(list);
		toDoCollaboration.setRole(role);
		
		collaborations.add(toDoCollaboration);
		
		return toDoCollaboration;
	}

	public Collection<ToDoCollaboration> getCollaborations() {
		return collaborations;
	}

	public void setCollaborations(Collection<ToDoCollaboration> collaborations) {
		this.collaborations = collaborations;
	}

}
