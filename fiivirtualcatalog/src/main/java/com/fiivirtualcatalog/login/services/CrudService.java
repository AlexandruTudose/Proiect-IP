package com.fiivirtualcatalog.login.services;

import java.util.List;

/**
 * Created by Alex on 02.05.2017.
 */
public interface CrudService<T> {

    T save(T entity);
    List<T> getAll();
    T findByEmail(String email);
    void delete(String email);
}
