package com.github.scompo.scompotodo.service.todolist;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.commons.AbstractCrudService;
import com.github.scompo.scompotodo.domain.todolist.ToDoList;
import com.github.scompo.scompotodo.domain.todolist.ToDoListDao;

@Service
@Transactional
public class ToDoListBusinessService extends
		AbstractCrudService<ToDoList, Long> implements ToDoListService {

	@Override
	public ToDoList doUpdate(ToDoList fromDb, ToDoList dto) {

		if (!fromDb.dataEquals(dto)) {

			fromDb.setName(dto.getName());
			fromDb.setLastEditDate(getCurrentDateTime());
			fromDb.setName(dto.getName());
		}

		return fromDb;
	}

	public static LocalDate getCurrentDateTime() {

		return LocalDate.now();
	}

	@Override
	@Autowired
	public void setRepository(
			PagingAndSortingRepository<ToDoList, Long> repository) {

		super.setRepository(repository);
	}

	@Override
	public ToDoList create(ToDoList t) {

		t.setCreationDate(getCurrentDateTime());
		t.setLastEditDate(t.getCreationDate());
		return super.create(t);
	}

	@Override
	public Page<ToDoList> getPagedForUsername(Pageable pageable, String username) {

		return ((ToDoListDao) getRepository()).findByCreator(username, pageable);
	}

}
