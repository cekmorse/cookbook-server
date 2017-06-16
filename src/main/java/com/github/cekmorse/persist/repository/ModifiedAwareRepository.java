package com.github.cekmorse.persist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by keith on 6/16/17.
 */
public interface ModifiedAwareRepository<T, ID extends Serializable> {
    boolean exists(ID aId, Date aSince, Boolean aUnmodified);
    T findOne(ID aId, Date aIfModifiedSince);
    Iterable<T> findAll(Date aIfModifiedSince);
    Page<T> findAll(Pageable aPage, Date aIfModifiedSince);
}
