package com.github.cekmorse.service;

import com.github.cekmorse.persist.domain.HasUuid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import static com.github.cekmorse.util.IterableUtil.toList;

/**
 * Created by keith on 6/21/17.
 */
public class CrudService<T extends HasUuid, R extends PagingAndSortingRepository<T, String>> {

    private R repository;

    public R getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(R aRepository) {
        repository = aRepository;
    }

    protected void checkUuid(String aUuid) {
        if (aUuid == null || aUuid.isEmpty()) {
            throw new IllegalArgumentException("Cannot search for a null id.");
        }
    }

    protected void checkDeleteUuid(String aUuid) {
        if (aUuid == null || aUuid.isEmpty()) {
            throw new IllegalArgumentException("Cannot delete an object with a null id.");
        }
    }

    public boolean exists(String aUuid) {
        checkUuid(aUuid);
        return getRepository().exists(aUuid);
    }

    public T findOne(String aUuid) {
        checkUuid(aUuid);
        return getRepository().findOne(aUuid);
    }

    public Page<T> findAll(Pageable aPage) {
        return getRepository().findAll(aPage);
    }

    public List<T> findAll() {
        return toList(getRepository().findAll());
    }

    public T save(T aObject) {
        if (aObject != null) {
            return getRepository().save(aObject);
        }
        return null;
    }

    public Iterable<T> save(Iterable<T> aObjects) {
        return toList(getRepository().save(aObjects));
    }

    public void delete(String aUuid) {
        checkDeleteUuid(aUuid);
        getRepository().delete(aUuid);
    }

    public void delete(T aObject) {
        if (aObject != null) {
            getRepository().delete(aObject);
        }
    }

    public void delete(Iterable<T> aObjects) {
        getRepository().delete(aObjects);
    }
}
