package com.github.scompo.scompotodo.domain.todolist;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.scompo.commons.ComparableByData;

@Entity
public class ToDoList implements Serializable, ComparableByData<ToDoList> {

	private static final long serialVersionUID = 3165749660417519161L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String creator;

	private LocalDate creationDate;

	private LocalDate lastEditDate;

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(LocalDate lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	@Override
	public boolean dataEquals(ToDoList other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastEditDate == null) {
			if (other.lastEditDate != null)
				return false;
		} else if (!lastEditDate.equals(other.lastEditDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoList other = (ToDoList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToDoList [id=" + id + ", name=" + name + ", creator=" + creator
				+ ", creationDate=" + creationDate + ", lastEditDate="
				+ lastEditDate + "]";
	}
}
