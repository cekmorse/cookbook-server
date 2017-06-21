package com.github.cekmorse.service;

import com.github.cekmorse.persist.domain.HasUuid;
import com.github.cekmorse.persist.repository.ModifiedAwareRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

import static com.github.cekmorse.util.IterableUtil.toList;


/**
 * Created by keith on 6/21/17.
 */
public class ModifiedAwareCrudService<T extends HasUuid, R extends PagingAndSortingRepository<T, String> & ModifiedAwareRepository<T, String>> extends CrudService<T, R> {
    public boolean exists(String aUuid, Date aIfUnmodifiedSince, Boolean aUnmodified) {
        checkUuid(aUuid);
        return getRepository().exists(aUuid, aIfUnmodifiedSince, aUnmodified);
    }

    public T findOne(String aUuid, Date aIfUnmodifiedSince) {
        checkUuid(aUuid);
        return getRepository().findOne(aUuid, aIfUnmodifiedSince);
    }

    public Page<T> findAll(Pageable aPage, Date aIfUnmodifiedSince) {
        return getRepository().findAll(aPage, aIfUnmodifiedSince);
    }

    public List<T> findAll(Date aIfUnmodifiedSince) {
        return toList(getRepository().findAll(aIfUnmodifiedSince));
    }

    public T save(T aObject, Date aIfUnmodifiedSince) {
        if (aObject != null && aIfUnmodifiedSince != null && exists(aObject.getUuid(), aIfUnmodifiedSince, true)) {
            return getRepository().save(aObject);
        }
        return null;
    }

    public void delete(String aUuid, Date aIfUnmodifiedSince) {
        checkDeleteUuid(aUuid);
        if (aIfUnmodifiedSince == null || exists(aUuid, aIfUnmodifiedSince, true)) {
            getRepository().delete(aUuid);
        }
    }

    public void delete(T aObject, Date aIfUnmodifiedSince) {
        if (aObject != null) {
            delete(aObject.getUuid(), aIfUnmodifiedSince);
        }
    }
}
