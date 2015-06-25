package com.github.scompo.scompotodo.test.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.scompotodo.test.commons.TransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalTest
public class ApplicationStartupTest {

	@Test
	public void test(){
		
		assertTrue(true);
	}
}
