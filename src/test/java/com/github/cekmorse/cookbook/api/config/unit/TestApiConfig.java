package com.github.cekmorse.cookbook.api.config.unit;

import com.github.cekmorse.api.controller.ControllerDefaults;
import com.github.cekmorse.service.RecipeService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by keith on 6/22/17.
 */
@Configuration
@ComponentScan(basePackageClasses = {ControllerDefaults.class})
public class TestApiConfig
{
    @Bean
    public RecipeService sampleService()
    {
        return Mockito.mock(RecipeService.class);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager()
    {
        return Mockito.mock(PlatformTransactionManager.class);
    }
}
