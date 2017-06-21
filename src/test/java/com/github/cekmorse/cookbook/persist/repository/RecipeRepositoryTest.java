package com.github.cekmorse.cookbook.persist.repository;


import com.github.cekmorse.cookbook.persist.config.PersistConfigs;
import com.github.cekmorse.persist.domain.RecipeDomain;
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

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

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

    private static final String TEST_NAME = "aTestname";
    private static final String TEST_UUID = "testUUID";
    private static final Date TEST_DATE = new Date();
    private static final String TEST_AUTHOR = "anAuthor";
    private static final String TEST_SOURCE = "aSource";

    @Autowired
    private RecipeRepository repository;

    private RecipeDomain testObject() {
        RecipeDomain aRecipe = new RecipeDomain();
        aRecipe.setUuid(TEST_UUID);
        aRecipe.setName(TEST_NAME);
        aRecipe.setCreatedAt(TEST_DATE);
        aRecipe.setUpdatedAt(TEST_DATE);
        aRecipe.setAuthor(TEST_AUTHOR);
        aRecipe.setSourceDoc(TEST_SOURCE);
        return aRecipe;
    }

    @Test
    public void testSearchNameContains() {
        repository.save(testObject());

        List<RecipeDomain> response = repository.searchNameContains("test");
        assertThat(response.size(), is(1));
        assertThat(response.get(0), is(allOf(
                hasProperty("name", is(TEST_NAME))
        )));
    }

}
