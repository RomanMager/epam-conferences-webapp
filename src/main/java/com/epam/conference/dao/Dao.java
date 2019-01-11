package com.epam.conference.dao;

import com.epam.conference.entity.Entity;
import com.epam.conference.exception.DaoException;

import java.util.List;

// TODO: can be an abstract class
//  - What is better to use?
//  -- Introduce K as a 'key' in method (ex. `delete(K id)`)
//  -- Make it auto-closable?
public interface Dao<T extends Entity> {
    void add(T entity) throws DaoException;

    void remove(T entity);

    void update(T entity);

    List<T> findAll() throws DaoException;
}
