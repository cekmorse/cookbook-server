package com.github.cekmorse.persist.repository.recipe;

import com.github.cekmorse.persist.domain.RecipeDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by keith on 6/16/17.
 */
@Slf4j
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {

    @Autowired
    RecipeRepository repository;

    @Override
    public boolean exists(String aId, Date aSince, Boolean aUnmodified) {
        return false;
    }

    @Override
    public RecipeDomain findOne(String aId, Date aIfModifiedSince) {
        return null;
    }

    @Override
    public Iterable<RecipeDomain> findAll(Date aIfModifiedSince) {
        return null;
    }

    @Override
    public Page<RecipeDomain> findAll(Pageable aPage, Date aIfModifiedSince) {
        return null;
    }
}
