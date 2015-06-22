package com.github.scompo.scompotodo.domain.users;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDao extends PagingAndSortingRepository<User, String> {

}
