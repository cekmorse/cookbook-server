package com.github.cekmorse.cookbook.api.controller;

import com.github.cekmorse.test.SystemIntegrationTest;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import org.junit.experimental.categories.Category;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by keith on 6/22/17.
 */
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@TestPropertySource("classpath:unit-test.properties")
@DatabaseSetup("classpath:sampleData.xml")
@Category(SystemIntegrationTest.class)
@Slf4j
public class RecipeControllerIT
{
    // TODO: 6/22/17 Setup ITs using what i built in tcs.
}
