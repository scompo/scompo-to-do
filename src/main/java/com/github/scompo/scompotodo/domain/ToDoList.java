package com.github.scompo.scompotodo.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class ToDoList {

	@GraphId
	private Long id;

	private String name;

	private LocalDate lastEditDate;

	@Fetch
	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Collection<ToDoCollaboration> collaborations;

	@RelatedTo(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Set<ToDoUser> collaborators;

	public ToDoList() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(LocalDate lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public Collection<ToDoCollaboration> getCollaborations() {
		return collaborations;
	}

	public void setCollaborations(Collection<ToDoCollaboration> collaborations) {
		this.collaborations = collaborations;
	}

	public Set<ToDoUser> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<ToDoUser> collaborators) {
		this.collaborators = collaborators;
	}
}
