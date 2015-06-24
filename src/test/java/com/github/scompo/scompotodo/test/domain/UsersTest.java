package com.github.scompo.scompotodo.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.AuthorizationRole;
import com.github.scompo.scompotodo.domain.ToDoUser;
import com.github.scompo.scompotodo.domain.ToDoUserRepository;
import com.github.scompo.scompotodo.test.commons.IntegrationTransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTransactionalTest
public class UsersTest {

	private static final String USER_NAME = "User Name";

	private static final String USER_PASSWORD = "userPassword";

	private static final String USER_LOGIN = "userLogin";

	@Autowired
	private Neo4jTemplate neo4jTemplate;

	@Autowired
	private ToDoUserRepository toDoUserRepository;

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
	public void testCreateUser() {

		ToDoUser userToCreate = null;
		ToDoUser userCreated = null;

		userToCreate = createUser(USER_LOGIN, USER_PASSWORD, USER_NAME);

		userCreated = toDoUserRepository.save(userToCreate);

		assertNotNull(userCreated);
		assertNotNull(userCreated.getId());

		assertEquals(userToCreate.getLogin(), userCreated.getLogin());
		assertEquals(userToCreate.getName(), userCreated.getName());
		assertEquals(userToCreate.getPassword(), userCreated.getPassword());
		assertTrue(userCreated.getAuthorizationRoles().contains(
				AuthorizationRole.ROLE_ADMIN));
		assertTrue(userCreated.getAuthorizationRoles().contains(
				AuthorizationRole.ROLE_USER));
		assertNotNull(userCreated.getLists());
		assertTrue(userCreated.getLists().isEmpty());

	}

	private ToDoUser createUser(String login, String password, String name) {

		ToDoUser userToCreate = new ToDoUser();

		Set<AuthorizationRole> authorizationRoles = new HashSet<>();

		authorizationRoles.add(AuthorizationRole.ROLE_ADMIN);
		authorizationRoles.add(AuthorizationRole.ROLE_USER);

		userToCreate.setAuthorizationRoles(authorizationRoles);
		userToCreate.setLogin(login);
		userToCreate.setPassword(password);
		userToCreate.setName(name);

		return userToCreate;
	}

}
