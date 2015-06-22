package com.github.scompo.commons;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractCrudService<T, ID extends Serializable>
		implements CrudService<T, ID>, InitializingBean {

	private static final String REPOSITORY_NULL_MESSAGE = "repository should not be null!";

	private static final Logger logger = LoggerFactory
			.getLogger(AbstractCrudService.class);

	private PagingAndSortingRepository<T, ID> repository;

	public Page<T> readPage(Pageable pageable) {

		logger.debug("Called readPage with pageable", pageable);

		return repository.findAll(pageable);
	}

	@Override
	public T create(T t) {

		logger.debug("Called create with t={}", t);

		return repository.save(t);
	}

	@Override
	public T read(ID id) {

		logger.debug("Called read with id={}", id);

		return repository.findOne(id);
	}

	@Override
	public T update(ID id, T t) {

		logger.debug("Called update with t={}, id={}", t, id);
		
		T fromDao = read(id);
		
		fromDao = doUpdate(fromDao, t);

		return repository.save(fromDao);
	}

	public abstract T doUpdate(T fromDb, T dto);

	@Override
	public void delete(ID id) {

		logger.debug("Called delete with id={}", id);

		repository.delete(id);
	}

	public PagingAndSortingRepository<T, ID> getRepository() {

		return repository;
	}

	public void setRepository(PagingAndSortingRepository<T, ID> repository) {

		this.repository = repository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (repository == null) {

			throw new IllegalArgumentException(REPOSITORY_NULL_MESSAGE);
		}
	}

}
