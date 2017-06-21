package com.github.cekmorse.persist.repository.recipe;

import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.persist.repository.PagingAndSortingQueryDslRepository;

import org.springframework.stereotype.Repository;

/**
 * Created by keith on 6/16/17.
 */
@Repository
public interface RecipeRepository extends PagingAndSortingQueryDslRepository<RecipeDomain, String>, RecipeRepositoryCustom {
    // Interface!! Don't add anything here.  Put it in the *Custom class.
}
