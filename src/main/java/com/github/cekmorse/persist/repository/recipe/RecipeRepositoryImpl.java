package com.github.cekmorse.persist.repository.recipe;

import com.github.cekmorse.persist.domain.QRecipeDomain;
import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.persist.util.PredicateHelper;
import com.mysema.query.types.expr.BooleanExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static com.github.cekmorse.persist.util.IterableUtil.toList;

/**
 * Created by keith on 6/16/17.
 */
@Slf4j
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {

    @Autowired
    RecipeRepository repository;

    @Override
    public List<RecipeDomain> searchNameContains(String partialName) {
        BooleanExpression criteria = QRecipeDomain.recipeDomain.name.contains(partialName);
        return toList(repository.findAll(criteria));
    }

    @Override
    public boolean exists(String aId, Date aSince, Boolean aUnmodified) {
        BooleanExpression id = QRecipeDomain.recipeDomain.uuid.eq(aId);
        BooleanExpression since = null;
        if (aSince != null) {
            if (aUnmodified != null && aUnmodified) {
                since = QRecipeDomain.recipeDomain.updatedAt.before(aSince).or(QRecipeDomain.recipeDomain.updatedAt.eq(aSince));
            } else {
                since = QRecipeDomain.recipeDomain.updatedAt.after(aSince);
            }
        }
        BooleanExpression criteria = PredicateHelper.andAll(id, since);
        return repository.exists(criteria);
    }

    @Override
    public RecipeDomain findOne(String aId, Date aIfModifiedSince) {
        BooleanExpression id = QRecipeDomain.recipeDomain.uuid.eq(aId);
        BooleanExpression since = aIfModifiedSince != null ? QRecipeDomain.recipeDomain.updatedAt.after(aIfModifiedSince) : null;
        BooleanExpression criteria = PredicateHelper.andAll(id, since);
        return repository.findOne(criteria);
    }

    @Override
    public Iterable<RecipeDomain> findAll(Date aIfModifiedSince) {
        if (aIfModifiedSince != null) {
            return repository.findAll(QRecipeDomain.recipeDomain.updatedAt.after(aIfModifiedSince));
        }
        return repository.findAll();
    }

    @Override
    public Page<RecipeDomain> findAll(Pageable aPage, Date aIfModifiedSince) {
        BooleanExpression criteria = aIfModifiedSince != null ? QRecipeDomain.recipeDomain.updatedAt.after(aIfModifiedSince) : null;
        if (aPage != null) {
            if (criteria != null) {
                return repository.findAll(criteria, aPage);
            }
            return repository.findAll(aPage);
        } else {
            if (criteria != null) {
                return new PageImpl<RecipeDomain>(toList(repository.findAll(criteria)));
            }
            return new PageImpl<RecipeDomain>(toList(repository.findAll()));
        }
    }
}
