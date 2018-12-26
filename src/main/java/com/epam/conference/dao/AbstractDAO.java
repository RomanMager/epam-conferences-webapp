package com.epam.conference.dao;

import com.epam.conference.entity.Entity;
import com.epam.conference.exception.DAOException;

import java.util.List;

// TODO: can be an abstract class
//  - What is better to use?
//  -- Introduce K as a 'key' in method (ex. `delete(K id)`)
//  -- Make it auto-closable?
public interface AbstractDAO<T extends Entity> {
    void add(T entity) throws DAOException;

    void remove(T entity);

    void update(T entity);

    List<T> findAll();
}
