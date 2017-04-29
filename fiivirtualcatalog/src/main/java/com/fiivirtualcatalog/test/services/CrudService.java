package com.fiivirtualcatalog.test.services;

/**
 * Created by Alexandru on 4/27/2017.
 */

import java.util.List;

public interface CrudService<T> {
    T save(T entity);

    List<T> getAll();

    T getById(Long id);

    void delete(Long id);
}