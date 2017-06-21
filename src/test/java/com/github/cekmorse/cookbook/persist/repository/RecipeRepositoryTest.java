package com.github.cekmorse.cookbook.persist.repository;


import com.github.cekmorse.cookbook.persist.config.PersistConfigs;
import com.github.cekmorse.persist.repository.recipe.RecipeRepository;
import com.github.cekmorse.test.RepositoryTest;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by keith on 6/20/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistConfigs.class}, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:sampleData.xml")
@TestPropertySource("classpath:unit-test.properties")
@Category(RepositoryTest.class)
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository repository;

    @Test
    public void testAnything() {
        System.out.println("---- made it here ----");
    }

}
