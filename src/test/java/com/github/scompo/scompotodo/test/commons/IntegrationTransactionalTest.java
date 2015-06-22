package com.github.scompo.scompotodo.test.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.github.scompo.scompotodo.Application;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback = true)
public @interface IntegrationTransactionalTest {

}
