package com.github.scompo.scompotodo.domain;

import java.util.Collection;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class List extends AbstractEntity{
	
	private String name;

	@Fetch
	@RelatedTo(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Set<User> collaborators;
	
	@RelatedToVia(type = "COLLABORATOR_ON", direction = Direction.INCOMING)
	private Collection<Collaboration> collaborations;

	public List() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<User> collaborators) {
		this.collaborators = collaborators;
	}

	public Collection<Collaboration> getCollaborations() {
		return collaborations;
	}

	public void setCollaborations(Collection<Collaboration> collaborations) {
		this.collaborations = collaborations;
	}
}
