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
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.CollaborationRole;
import com.github.scompo.scompotodo.domain.ToDoList;
import com.github.scompo.scompotodo.domain.ToDoListRepository;
import com.github.scompo.scompotodo.domain.ToDoUser;
import com.github.scompo.scompotodo.domain.ToDoUserRepository;
import com.github.scompo.scompotodo.test.commons.IntegrationTransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTransactionalTest
public class ListTest {

	@Autowired
	private ToDoListRepository toDoListRepository;

	@Autowired
	private ToDoUserRepository toDoUserRepository;

	@Autowired
	private Neo4jTemplate neo4jTemplate;

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

		ToDoUser userSaved1 = createAndSaveUser(USER_LOGIN_1, USER_PASSWORD_1,
				USER_NAME_1);

		ToDoUser userSaved2 = createAndSaveUser(USER_LOGIN_2, USER_PASSWORD_2,
				USER_NAME_2);

		ToDoList listToSave = null;
		ToDoList listSaved = null;

		listToSave = createList(LIST_NAME);

		listSaved = toDoListRepository.save(listToSave);
		
		userSaved1.userOf(listSaved, CollaborationRole.EDITOR);
		userSaved2.userOf(listSaved, CollaborationRole.VIEWER);
		
		toDoUserRepository.save(userSaved1);
		toDoUserRepository.save(userSaved2);
		
		listSaved = toDoListRepository.findOne(listSaved.getId());

		assertFalse(listSaved.getCollaborators().isEmpty());
		assertTrue(listSaved.getCollaborators().contains(userSaved1));
		assertTrue(listSaved.getCollaborators().contains(userSaved2));
	}

	private ToDoUser createAndSaveUser(String userLogin, String userPassword,
			String userName) {

		return toDoUserRepository.save(createUser(userLogin, userPassword,
				userName));
	}

}
