package com.github.scompo.scompotodo.domain;

import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class ToDoList extends AbstractEntity{
	
	private String name;

	@Fetch
	@RelatedTo(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Set<ToDoUser> collaborators;
	
	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Collection<ToDoCollaboration> collaborations;

	public ToDoList() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ToDoUser> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<ToDoUser> collaborators) {
		this.collaborators = collaborators;
	}

	public Collection<ToDoCollaboration> getCollaborations() {
		return collaborations;
	}

	public void setCollaborations(Collection<ToDoCollaboration> collaborations) {
		this.collaborations = collaborations;
	}
}
