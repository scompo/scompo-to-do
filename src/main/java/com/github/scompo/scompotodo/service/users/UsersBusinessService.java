package com.github.scompo.scompotodo.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.commons.AbstractCrudService;
import com.github.scompo.scompotodo.domain.users.User;

@Service
@Transactional
public class UsersBusinessService extends AbstractCrudService<User, String> {

	@Override
	@Autowired
	public void setRepository(
			PagingAndSortingRepository<User, String> repository) {

		super.setRepository(repository);
	}

}
