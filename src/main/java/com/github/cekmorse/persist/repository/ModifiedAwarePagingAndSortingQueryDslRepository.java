package com.github.cekmorse.persist.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by keith on 6/16/17.
 */
@NoRepositoryBean
public interface ModifiedAwarePagingAndSortingQueryDslRepository<T, ID extends Serializable> extends ModifiedAwareRepository<T, ID>, PagingAndSortingQueryDslRepository<T, ID> {
}
