package com.github.cekmorse.persist.repository.recipe;

import com.github.cekmorse.persist.domain.Recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * Created by keith on 6/16/17.
 */
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {
    @Override
    public boolean exists(String aId, Date aSince, Boolean aUnmodified) {
        return false;
    }

    @Override
    public Recipe findOne(String aId, Date aIfModifiedSince) {
        return null;
    }

    @Override
    public Iterable<Recipe> findAll(Date aIfModifiedSince) {
        return null;
    }

    @Override
    public Page<Recipe> findAll(Pageable aPage, Date aIfModifiedSince) {
        return null;
    }
}
