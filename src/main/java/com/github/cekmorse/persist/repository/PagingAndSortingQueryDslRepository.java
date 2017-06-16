package com.github.cekmorse.persist.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by keith on 6/16/17.
 */
@NoRepositoryBean
public interface PagingAndSortingQueryDslRepository<T,I extends Serializable> extends PagingAndSortingRepository<T, I>, QueryDslPredicateExecutor<T>
{
}
