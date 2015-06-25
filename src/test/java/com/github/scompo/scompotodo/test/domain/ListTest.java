package com.github.scompo.scompotodo.test.domain;

import static com.github.scompo.scompotodo.test.domain.TestUtils.LIST_NAME;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_LOGIN_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_LOGIN_2;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_NAME_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_NAME_2;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_PASSWORD_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_PASSWORD_2;
import static com.github.scompo.scompotodo.test.domain.TestUtils.createList;
import static com.github.scompo.scompotodo.test.domain.TestUtils.createUser;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.CollaborationRole;
import com.github.scompo.scompotodo.domain.List;
import com.github.scompo.scompotodo.domain.User;
import com.github.scompo.scompotodo.repository.ToDoListRepository;
import com.github.scompo.scompotodo.services.ToDoUserDetailsService;
import com.github.scompo.scompotodo.test.commons.TransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalTest
public class ListTest {

	@Autowired
	private ToDoListRepository toDoListRepository;

	@Autowired
	private ToDoUserDetailsService toDoUserDetailsService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		User userSaved1 = createAndSaveUser(USER_LOGIN_1, USER_PASSWORD_1,
				USER_NAME_1);

		User userSaved2 = createAndSaveUser(USER_LOGIN_2, USER_PASSWORD_2,
				USER_NAME_2);

		List listToSave = null;
		List listSaved = null;

		listToSave = createList(LIST_NAME);

		listSaved = toDoListRepository.save(listToSave);
		
		userSaved1.userOf(listSaved, CollaborationRole.EDITOR);
		userSaved2.userOf(listSaved, CollaborationRole.VIEWER);
		
		toDoUserDetailsService.save(userSaved1);
		toDoUserDetailsService.save(userSaved2);
		
		listSaved = toDoListRepository.findOne(listSaved.getId());

		assertFalse(listSaved.getCollaborators().isEmpty());
		assertTrue(listSaved.getCollaborators().contains(userSaved1));
		assertTrue(listSaved.getCollaborators().contains(userSaved2));
	}

	private User createAndSaveUser(String userLogin, String userPassword,
			String userName) {

		return toDoUserDetailsService.save(createUser(userLogin, userPassword,
				userName));
	}

}
