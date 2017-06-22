package com.github.cekmorse.service;

import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.persist.repository.recipe.RecipeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by keith on 6/21/17.
 */
@Service
public class RecipeService extends ModifiedAwareCrudService<RecipeDomain, RecipeRepository> {
    public List<RecipeDomain> searchNameContains(String aNameSegment) {
        if (aNameSegment == null || aNameSegment.isEmpty() || aNameSegment.length() < 3) {
            throw new IllegalArgumentException("Cannot search without at least three letters.");
        }
        return getRepository().searchNameContains(aNameSegment);
    }
}
