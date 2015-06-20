package com.github.scompo.scompotodo.test.hello;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.service.hello.HelloService;
import com.github.scompo.scompotodo.test.commons.IntegrationTransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTransactionalTest
public class HelloServiceTest {

	@Autowired
	private HelloService helloService;

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
	public void testSayHello() {

		assertEquals(HelloService.HELLO_STRING, helloService.sayHello());
	}

}
