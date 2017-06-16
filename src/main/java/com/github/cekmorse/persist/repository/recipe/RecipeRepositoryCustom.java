package com.github.cekmorse.persist.repository.recipe;

import com.github.cekmorse.persist.domain.Recipe;
import com.github.cekmorse.persist.repository.ModifiedAwareRepository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by keith on 6/16/17.
 */
@NoRepositoryBean
public interface RecipeRepositoryCustom extends ModifiedAwareRepository<Recipe, String> {
    // Add custom method signatures here.  No implementations.
}