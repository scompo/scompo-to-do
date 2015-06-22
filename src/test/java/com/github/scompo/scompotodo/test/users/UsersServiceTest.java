package com.github.scompo.scompotodo.test.users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.users.User;
import com.github.scompo.scompotodo.domain.users.UserFactory;
import com.github.scompo.scompotodo.service.users.UsersService;
import com.github.scompo.scompotodo.test.commons.IntegrationTransactionalTest;

@IntegrationTransactionalTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersServiceTest {

	public enum UsersForTestType {

		USER_OK_1
	}

	public static final String USERNAME_1 = "username1";

	public static final String EMAIL_1 = "test1@test.com";

	public static final String EMAIL_2 = "test2@test.com";

	@Autowired
	private UsersService usersService;

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
	public void testReadPageEmpty() {

		Pageable pageable = null;

		Page<User> res = null;

		res = usersService.readPage(pageable);

		assertNotNull(res);
		assertTrue(res.getContent().isEmpty());
	}

	@Test
	public void testReadPageWithUsers() {

		User user = createAndSaveUser(UsersForTestType.USER_OK_1);

		Pageable pageable = null;

		Page<User> res = null;

		res = usersService.readPage(pageable);

		assertNotNull(res);
		assertEquals(1, res.getContent().size());

		assertEquals(user, res.getContent().get(0));
	}

	@Test
	public void testCreateOk() {

		User res = null;

		User user = createUser(UsersForTestType.USER_OK_1);

		res = usersService.create(user);

		assertNotNull(res);
		assertEquals(user.getUsername(), res.getUsername());
		assertEquals(user.getEmail(), res.getEmail());
	}

	public User createUser(UsersForTestType type) {

		User res = null;

		switch (type) {

		case USER_OK_1:

			res = UserFactory.create(USERNAME_1, EMAIL_1);
			break;

		default:
			break;
		}

		return res;
	}

	public User createAndSaveUser(UsersForTestType type) {

		return usersService.create(createUser(type));
	}

	@Test
	public void testRead() {

		User user = createAndSaveUser(UsersForTestType.USER_OK_1);

		User res = usersService.read(user.getUsername());

		assertNotNull(res);
		assertEquals(user.getUsername(), res.getUsername());
		assertEquals(user.getEmail(), res.getEmail());
	}

	@Test
	public void testUpdate() {

		User user = createAndSaveUser(UsersForTestType.USER_OK_1);

		User userUpdated = new User();

		userUpdated.setEmail(user.getEmail());
		userUpdated.setEmail(EMAIL_2);

		User res = usersService.update(user.getUsername(), userUpdated);

		assertNotNull(res);
		assertEquals(user.getUsername(), res.getUsername());
		assertEquals(userUpdated.getEmail(), res.getEmail());
	}

	@Test
	public void testDelete() {

		User user = createAndSaveUser(UsersForTestType.USER_OK_1);

		usersService.delete(user.getUsername());

		assertNull(usersService.read(user.getUsername()));

	}

}
