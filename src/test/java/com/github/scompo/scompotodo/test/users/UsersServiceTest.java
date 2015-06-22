package com.github.scompo.scompotodo.test.users;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.domain.users.User;
import com.github.scompo.scompotodo.service.users.UsersService;
import com.github.scompo.scompotodo.test.commons.IntegrationTransactionalTest;

@IntegrationTransactionalTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersServiceTest {

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
	public void testCreate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRead() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRepository() {
		fail("Not yet implemented"); // TODO
	}

}
