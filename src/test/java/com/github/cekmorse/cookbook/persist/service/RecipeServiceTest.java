package com.github.cekmorse.cookbook.persist.service;

import com.github.cekmorse.cookbook.persist.service.config.unit.ServiceConfig;
import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.persist.repository.recipe.RecipeRepository;
import com.github.cekmorse.service.RecipeService;
import com.github.cekmorse.test.UnitTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by keith on 6/21/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class}, loader = AnnotationConfigContextLoader.class)
@TestPropertySource("classpath:unit-test.properties")
@Category(UnitTest.class)
public class RecipeServiceTest {

    private static final Date A_DATE = new Date();
    private static final String TEST_UUID = "101";
    private static final String NAME_FIRST = "test";
    private static final String NAME_LAST = "Name";
    private static final String TEST_NAME = NAME_FIRST + NAME_LAST;
    private static final Date TEST_CREATED_AT = A_DATE;
    private static final Date TEST_UPDATED_AT = A_DATE;
    private static final String TEST_AUTHOR = "testAuthor";
    private static final String TEST_SOURCE_DOC = "testSourceDoc";

    @Autowired
    protected RecipeService service;

    @Autowired
    protected RecipeRepository repository;

    private RecipeDomain createRecipeDomain() {
        return new RecipeDomain(
                TEST_UUID,
                TEST_NAME,
                TEST_CREATED_AT,
                TEST_UPDATED_AT,
                TEST_AUTHOR,
                TEST_SOURCE_DOC
        );
    }

    private void testValidName(String aName, int numberFound) {
        RecipeDomain aObject = createRecipeDomain();
        List<RecipeDomain> mockResults = new ArrayList<>(Arrays.asList(aObject));

        when(repository.searchNameContains(eq(aName))).thenReturn(mockResults);

        List<RecipeDomain> found = service.searchNameContains(aName);
        assertThat(found.size(), is(1));
    }

    @Test
    public void testSearchNameContains_fullName() {
        testValidName(TEST_NAME, 1);
    }

    @Test
    public void testSearchNameContains_startsWith() {
        testValidName(NAME_FIRST, 1);
    }

    @Test
    public void testSearchNameContains_endsWith() {
        testValidName(NAME_LAST, 1);
    }

    @Test
    public void testSearchNameContains_invalidName() {
        testValidName("Invalid", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchNameContains_null() {
        service.searchNameContains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchNameContains_shortString() {
        service.searchNameContains("A");
    }
}
