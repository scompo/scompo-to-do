package com.github.scompo.scompotodo.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.scompo.commons.AbstractCrudService;
import com.github.scompo.scompotodo.domain.users.User;
import com.github.scompo.scompotodo.domain.users.UserDetailsImpl;

@Service
@Transactional
public class UsersBusinessService extends AbstractCrudService<User, String>
		implements UsersService {

	@Override
	@Autowired
	public void setRepository(
			PagingAndSortingRepository<User, String> repository) {

		super.setRepository(repository);
	}

	@Override
	public User doUpdate(User fromDb, User dto) {

		fromDb.setEmail(dto.getEmail());

		return fromDb;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User letto = read(username);
		
		return new UserDetailsImpl(letto.getUsername(), letto.getPassword());
	}

}
