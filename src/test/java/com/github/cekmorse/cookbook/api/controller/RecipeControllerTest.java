package com.github.cekmorse.cookbook.api.controller;

import com.github.cekmorse.api.controller.RecipeController;
import com.github.cekmorse.api.exception.BadRequestException;
import com.github.cekmorse.api.exception.NotModifiedException;
import com.github.cekmorse.api.exception.ResourceNotFoundException;
import com.github.cekmorse.cookbook.api.config.unit.TestApiConfigs;
import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.service.RecipeService;
import com.github.cekmorse.test.UnitTest;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Date;

/**
 * Created by keith on 6/22/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApiConfigs.class}, loader = AnnotationConfigContextLoader.class)
@TestPropertySource("classpath:unit-test.properties")
@Category(UnitTest.class)
public class RecipeControllerTest {

    private static final Date now = new Date();
    private static final Date past = new DateTime(now).minusMinutes(1).toDate();
    private static final Date future = new DateTime(now).plusMinutes(1).toDate();

    @Autowired
    protected RecipeService service;

    @Autowired
    protected RecipeController controller;

    private void get_Success(Date updatedAt) throws NotModifiedException, BadRequestException, ResourceNotFoundException {
        // init
        RecipeDomain recipe = new RecipeDomain("1", "Recipe", now, now, "Author", "SourceDoc");

        // setup mock
        Mockito.when(service.findOne(Matchers.any(String.class), Matchers.any(Date.class))).thenReturn(recipe);
        Mockito.when(service.findOne(Matchers.any(String.class))).thenReturn(recipe);

        // test and verify - use JUnit 4 to notify if exceptions are thrown.  Return object is not modified by controller.
        if (updatedAt != null) {
            controller.getRecipe("1", updatedAt);
        } else {
            controller.getRecipe("1", null);
        }
    }

    @Test
    public void testGetSuccess() throws BadRequestException, NotModifiedException, ResourceNotFoundException {
        get_Success(null);
    }

    @Test
    public void testGetSuccess_Updated_Past() throws BadRequestException, NotModifiedException, ResourceNotFoundException {
        get_Success(past);
    }

    @Test
    public void testGetSuccess_Updated_Now() throws BadRequestException, NotModifiedException, ResourceNotFoundException {
        get_Success(now);
    }

    @Test(expected = NotModifiedException.class)
    public void testGetSuccess_Updated_Future() throws BadRequestException, NotModifiedException, ResourceNotFoundException {
        get_Success(future);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGet_Fail_NotFound() throws NotModifiedException, BadRequestException, ResourceNotFoundException {
        // setup mock
        Mockito.when(service.findOne(Matchers.anyString())).thenReturn(null);
        Mockito.when(service.findOne(Matchers.anyString(), Matchers.any(Date.class))).thenReturn(null);

        controller.getRecipe("1", null);
    }

    @Test(expected = BadRequestException.class)
    public void testGet_Fail_NoId() throws NotModifiedException, BadRequestException, ResourceNotFoundException {
        controller.getRecipe(null, null);
    }
}
