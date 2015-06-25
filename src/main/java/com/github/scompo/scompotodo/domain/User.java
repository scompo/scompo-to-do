package com.github.scompo.scompotodo.domain;

import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class User extends AbstractEntity {

	@Indexed(unique = true, failOnDuplicate = true)
	private String login;

	private String name;

	private String password;

	private Set<AuthorizationRole> authorizationRoles;

	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.OUTGOING)
	private Collection<Collaboration> collaborations;

	public User() {

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

	public Collaboration userOf(List list, CollaborationRole role) {

		Collaboration toDoCollaboration = new Collaboration();
		toDoCollaboration.setUser(this);
		toDoCollaboration.setList(list);
		toDoCollaboration.setRole(role);

		collaborations.add(toDoCollaboration);

		return toDoCollaboration;
	}

	public Collection<Collaboration> getCollaborations() {
		return collaborations;
	}

	public void setCollaborations(Collection<Collaboration> collaborations) {
		this.collaborations = collaborations;
	}

	@Override
	public String toString() {
		return "User [  getId()= " + getId() + ", login=" + login + ", name="
				+ name + ", password=" + password + ", authorizationRoles="
				+ authorizationRoles + ", collaborations=" + collaborations
				+ "]";
	}

}
