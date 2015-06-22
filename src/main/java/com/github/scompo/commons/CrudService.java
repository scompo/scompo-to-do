package com.github.scompo.commons;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID extends Serializable> {

	Page<T> readPage(Pageable pageable);

	T create(T t);

	T read(ID id);

	T update(ID id, T t);

	void delete(ID id);
}
