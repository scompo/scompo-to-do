package com.github.scompo.scompotodo.test.domain;

import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_LOGIN_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_NAME_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.USER_PASSWORD_1;
import static com.github.scompo.scompotodo.test.domain.TestUtils.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.AuthorizationRole;
import com.github.scompo.scompotodo.domain.User;
import com.github.scompo.scompotodo.repository.UserRepository;
import com.github.scompo.scompotodo.test.commons.TransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalTest
public class UsersTest {

	@Autowired
	@Lazy
	private UserRepository toDoUserRepository;

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

		User userToCreate = null;
		User userCreated = null;

		userToCreate = createUser(USER_LOGIN_1, USER_PASSWORD_1, USER_NAME_1);

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
		assertNotNull(userCreated.getCollaborations());
		assertTrue(userCreated.getCollaborations().isEmpty());

	}

}
