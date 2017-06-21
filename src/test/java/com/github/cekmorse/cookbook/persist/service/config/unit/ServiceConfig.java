package com.github.cekmorse.cookbook.persist.service.config.unit;

import com.github.cekmorse.persist.repository.recipe.RecipeRepository;
import com.github.cekmorse.service.CrudService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by keith on 6/21/17.
 */
@Configuration
@ComponentScan(basePackageClasses = {CrudService.class})
public class ServiceConfig {

    @Bean
    public RecipeRepository recipeRepository() {
        return Mockito.mock(RecipeRepository.class);
    }

}
